FROM openjdk:11

COPY ./target/gateway-0.0.1.SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch gateway-0.0.1.SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "gateway-0.0.1.SNAPSHOT.jar"]