FROM eclipse-temurin:17-jdk AS builder
ARG GRADLE_OPTS="-Dorg.gradle.daemon=false"
WORKDIR /app
ADD . .
RUN ./gradlew assemble

FROM eclipse-temurin:17-jre
LABEL author="Clairton Luz <clairton.c.l@gmail.com>"
WORKDIR /app
VOLUME /tmp
COPY --from=builder /app/build/libs/*1.0.0.jar app.jar
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080
