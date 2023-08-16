FROM amazoncorretto:17-alpine-jdk
COPY build/libs/prime-number-consumer-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8090