FROM openjdk:17-alpine
ADD /target/mongo-demo-0.0.1-SNAPSHOT.jar /myapp.jar
ENTRYPOINT ["java", "-jar", "myapp.jar"]
