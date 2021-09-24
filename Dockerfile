FROM openjdk:11
COPY build/libs/voting-api-0.0.1-SNAPSHOT.jar voting-message-producer.jar
ENTRYPOINT ["java","-jar","voting-message-producer.jar"]