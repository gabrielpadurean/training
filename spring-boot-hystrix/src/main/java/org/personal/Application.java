package org.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Startup class for the application.
 * 
 * @author gabi
 */
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}