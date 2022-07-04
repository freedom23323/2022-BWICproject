FROM openjdk:11

COPY ./target/bid-svc-0.0.1.SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch bid-svc-0.0.1.SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "bid-svc-0.0.1.SNAPSHOT.jar"]