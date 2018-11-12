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
    private static final DateTimeFormatter NASA_APOD_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Value("${nasa.apiKey}")
    private String apiKey;

    @Value("${nasa.apod.url")
    private String apodUrl;

    @Value("${nasa.apod.default.title}")
    private String defaultTitle;

    @Value("${nasa.apod.default.explanation}")
    private String defaultExplanation;

    @Value("${nasa.apod.default.url}")
    private String defaultUrl;

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getDefaultAPOD")
    public APOD getAPOD(LocalDate localDate) {
        return restTemplate.getForObject(apodUrl, APOD.class, localDate.format(NASA_APOD_DATE_FORMATTER), apiKey);
    }

    public APOD getDefaultAPOD(LocalDate localDate) {
        APOD apod = new APOD();

        apod.setTitle(defaultTitle);
        apod.setExplanation(defaultExplanation);
        apod.setHdurl(defaultUrl);
        apod.setDate(LocalDate.now());

        return apod;
    }
}