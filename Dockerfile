FROM openjdk:8
MAINTAINER Vineeth Aravelli <vineeth.aravelli@gmail.com>
ADD target/advertiser-spring-boot-app.jar  advertiser-spring-boot-app.jar
EXPOSE 8080 8090
ENTRYPOINT ["java","-jar","advertiser-spring-boot-app.jar"]