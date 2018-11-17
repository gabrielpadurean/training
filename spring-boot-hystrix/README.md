# Name
spring-boot-hystrix

# Description
Basic Spring Boot application to be used as an example with Hystrix.

## Package structure
Application consists of four main packages:
+ `api` used for the API exposed by the application
+ `domain` used for domain model classes
+ `service` used for the service layer (business classes)
+ `client` used for REST integrations

## Running from command line
Follow these steps to start the application:
+ run `mvn clean install`
+ run `mvn spring-boot:run` or `java -jar target/spring-boot-hystrix-0.0.1-SNAPSHOT.jar` to start the application

## URLs
http://localhost:8080  
http://localhost:8080/hystrix  
http://localhost:9999/actuator/hystrix.stream  