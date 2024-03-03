FROM openjdk:17
WORKDIR /EmployeeMicroService
ADD target/EmployeeMicroservice-0.0.1-SNAPSHOT.jar EmployeeMicroservice.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "EmployeeMicroservice.jar"]