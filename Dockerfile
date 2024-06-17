FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk-17-codingsoldier/openjdk-17-jdk-slim-enhance
EXPOSE 8080

COPY --from=build target/classes/com/api/sx/SxApplication.class app.jar
ENTRYPOINT [ "java", "-jar" , "app.jar"]