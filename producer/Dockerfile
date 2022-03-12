FROM adoptopenjdk/openjdk11:alpine
RUN mkdir build
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /build/app.jar
WORKDIR /build
ENTRYPOINT ["java", "-jar", "app.jar"]