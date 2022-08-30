## file name: example1.Dockerfile
FROM openjdk:8-jdk-alpine
ARG WORKDIR=/home/app
COPY . ${WORKDIR}
WORKDIR ${WORKDIR}
RUN ./gradlew :clean :build -x test --no-daemon
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]