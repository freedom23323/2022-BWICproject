FROM openjdk:11

COPY ./target/BWIC-service-0.0.1.SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch BWIC-service-0.0.1.SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "BWIC-service-0.0.1.SNAPSHOT.jar"]