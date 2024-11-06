
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/member-0.0.1-SNAPSHOT.jar member-service.jar

EXPOSE 9500

ENTRYPOINT ["java", "-jar", "member-service.jar"]

ENV TZ=Asia/Seoul