FROM openjdk:11.0.2-jre-slim

COPY ./target/local-config-server-*.jar /local-config-server.jar

ENTRYPOINT ["java", "-jar", "/local-config-server.jar"]