FROM openjdk:11
EXPOSE 80
ARG JAR_FILE=target/payslip-generator.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]