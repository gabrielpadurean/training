package org.personal.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibraryService {
    private static final String LIBRARY_SERVICE_URL = "http://localhost:8080/server/books";

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getBooksBackup")
    public String getBooks() {
        return restTemplate.getForObject(LIBRARY_SERVICE_URL, String.class);
    }

    public String getBooksBackup() {
        return "Unknown";
    }
}