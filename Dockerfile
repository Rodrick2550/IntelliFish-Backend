FROM amazoncorretto:17-alpine3.16
ADD target/intelliFishAPI.jar intelliFishAPI.jar
ENTRYPOINT ["java", "-jar", "intelliFishAPI.jar"]