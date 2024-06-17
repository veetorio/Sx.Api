FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim
EXPOSE 8080

ENV SPRING_DATASOURCE_URL=jdbc:postgres://admin:M6gRKhW94rB0shDlzNFYTPNCwquy0JYZ@dpg-cpo4kq88fa8c73bb8g2g-a/db_shooes
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=M6gRKhW94rB0shDlzNFYTPNCwquy0JYZ

COPY --from=build /target/sx-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar" , "app.jar"]