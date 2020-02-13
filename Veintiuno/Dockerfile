FROM maven:3.6.0-jdk-11-slim

COPY src /home/ventiuno/src
COPY pom.xml /home/ventiuno

WORKDIR /home/ventiuno

RUN mvn test
