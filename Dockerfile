FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD


COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/techBrewers-send-offers-1.0.jar /app/

ENV PORT 8085

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "techBrewers-send-offers-1.0.jar"]
