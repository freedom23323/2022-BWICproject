FROM openjdk:11

COPY ./target/account-svc-0.0.1.SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch account-svc-0.0.1.SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "account-svc-0.0.1.SNAPSHOT.jar"]