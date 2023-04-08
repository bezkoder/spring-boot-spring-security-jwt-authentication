FROM openjdk:8-alpine
MAINTAINER "Ramazan Sakin"
ADD target/spring-boot-security-jwt-0.0.1-SNAPSHOT.jar spring-boot-security-jwt-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-security-jwt-0.0.1-SNAPSHOT.jar"]