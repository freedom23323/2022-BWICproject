FROM openjdk:11

COPY ./target/BWIC-api-0.0.1.SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch BWIC-api-0.0.1.SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "BWIC-api-0.0.1.SNAPSHOT.jar"]