FROM openjdk:11
COPY target/spring-boot-with-aws.jar .
CMD ["java", "-jar", "spring-boot-with-aws.jar"]