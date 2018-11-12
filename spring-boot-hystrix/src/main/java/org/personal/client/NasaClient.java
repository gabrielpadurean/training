package org.personal.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.personal.domain.APOD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class NasaClient {
    private static final String NASA_APOD_URL = "https://api.nasa.gov/planetary/apod?date={date}&api_key={apiKey}";
    private static final DateTimeFormatter NASA_APOD_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Value("${nasa.apiKey}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getDefaultAPOD")
    public APOD getAPOD(LocalDate localDate) {
        return restTemplate.getForObject(NASA_APOD_URL, APOD.class, localDate.format(NASA_APOD_DATE_FORMATTER), apiKey);
    }

    public APOD getDefaultAPOD(LocalDate localDate) {
        return null;
    }
}