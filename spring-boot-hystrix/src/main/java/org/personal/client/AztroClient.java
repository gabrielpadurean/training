package org.personal.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.personal.domain.Aztro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AztroClient {
    @Value("${aztro.url}")
    private String aztroUrl;

    @Value("${aztro.sign}")
    private String defaultSign;

    @Value("${aztro.day}")
    private String defaultDay;

    @Value("${aztro.mood}")
    private String defaultMood;

    @Value("${aztro.description}")
    private String defaultDescription;

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getDefaultAztro")
    public Aztro getAztro(String sign, String day) {
        Aztro aztro =  restTemplate.postForObject(aztroUrl, null, Aztro.class, sign, day);

        aztro.setSign(sign);
        aztro.setDay(day);

        return aztro;
    }

    public Aztro getDefaultAztro(String sign, String day) {
        Aztro aztro = new Aztro();

        aztro.setSign(defaultSign);
        aztro.setDay(defaultDay);
        aztro.setMood(defaultMood);
        aztro.setDescription(defaultDescription);

        return aztro;
    }
}