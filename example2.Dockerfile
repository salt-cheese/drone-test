## file name: example2.Dockerfile
FROM openjdk:8-jdk-alpine
ARG WORKDIR=/home/app
COPY . ${WORKDIR}
WORKDIR ${WORKDIR}
RUN ./gradlew :clean :build -x test --no-daemon

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=${WORKDIR}/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]