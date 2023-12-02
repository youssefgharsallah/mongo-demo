FROM maven:3.8.5-openjdk-17 as build
RUN git clone https://github.com/alidaoud7/mongo-demo.git
WORKDIR /mongo-demo
RUN mvn -f pom.xml clean package -DskipTests
FROM openjdk:17-alpine
ARG JAR_FILE=/mongo-demo/target/mongo-demo-0.0.1-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","application.jar"]