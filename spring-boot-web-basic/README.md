# Name
spring-boot-web-basic

# Description
Basic Spring Boot setup to start other web projects with.
This can be used as an example for project structure and initial dependencies and must be kept clean.

## Package structure
Application consists of four main packages:
+ `api` used for the API exposed by the application
+ `domain` used for domain model classes
+ `service` used for the service layer (business classes) 
+ `web` used for the web layer of the application

## Running from command line
Follow these steps to start the application:
+ run `mvn clean install`
+ run `mvn spring-boot:run` or `java -jar target/spring-boot-web-basic-0.0.1-SNAPSHOT.jar` to start the application