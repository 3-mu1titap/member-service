package com.multitap.member.application;

import org.springframework.web.multipart.MultipartFile;

public interface DataInsertService {
    void addMemberProfileImageFromCsv(MultipartFile file);

}
