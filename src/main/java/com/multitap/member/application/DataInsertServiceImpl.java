package com.multitap.member.application;

import com.multitap.member.common.exception.BaseException;
import com.multitap.member.common.response.BaseResponseStatus;
import com.multitap.member.entity.MemberProfileImage;
import com.multitap.member.infrastructure.MemberProfileImageRepository;
import com.multitap.member.kafka.producer.KafkaProducerService;
import com.multitap.member.kafka.producer.ProfileImageDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class DataInsertServiceImpl implements DataInsertService {

    private final MemberProfileImageRepository memberProfileImageRepository;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public void addMemberProfileImageFromCsv(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            List<CSVRecord> records = csvParser.getRecords();

            for (CSVRecord record : records) {
                String uuid = record.get("uuid");
                String profileImageUrl = record.get("profileImageUrl");

                MemberProfileImage memberProfileImage = MemberProfileImage.builder()
                        .uuid(uuid)
                        .profileImageUrl(profileImageUrl)
                        .build();

                memberProfileImageRepository.save(memberProfileImage);
                kafkaProducerService.sendCreateProfileImageUrl(ProfileImageDto.from(memberProfileImage));
            }
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
