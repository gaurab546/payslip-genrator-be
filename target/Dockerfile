FROM openjdk:11-jdk-alpine
EXPOSE 80
ARG JAR_FILE=target/payslip-generator.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]