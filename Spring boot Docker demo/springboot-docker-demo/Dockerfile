FROM eclipse-temurin:17

LABEL mentainer="waghsudam2@gmail.com"

WORKDIR /app

COPY build/libs/springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar

ENTRYPOINT  [   \
           "java",  \
           "-jar",  \
           "springboot-docker-demo.jar" \
           ]