FROM openjdk:21-slim
COPY target/BallSquadApi-0.0.1-SNAPSHOT.jar BallSquadApi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/BallSquadApi-0.0.1-SNAPSHOT.jar"]