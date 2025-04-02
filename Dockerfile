FROM openjdk:25-slim-bullseye
ADD target/rest-demo2.jar rest-demo2.jar
ENTRYPOINT ["java","-jar","/rest-demo2.jar"]