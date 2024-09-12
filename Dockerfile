FROM openjdk:17
WORKDIR /app
COPY target/phrases.jar /app/phrases.jar
ENTRYPOINT ["java", "-jar", "phrases.jar"]