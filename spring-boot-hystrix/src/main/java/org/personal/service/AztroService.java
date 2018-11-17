package org.personal.service;

import org.personal.client.AztroClient;
import org.personal.domain.Aztro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AztroService {
    private List<String> signs = Arrays.asList("Aries", "Libra", "Taurus", "Scorpio", "Gemini", "Sagittarius", "Cancer", "Capricorn", "Leo", "Aquarius", "Virgo", "Pisces");
    private List<String> days = Arrays.asList("Yesterday", "Today", "Tomorrow");

    @Autowired
    private AztroClient aztroClient;


    public Aztro getAztro() {
        int signsIndex = ThreadLocalRandom.current().nextInt(0, 12);
        int daysIndex = ThreadLocalRandom.current().nextInt(0, 3);

        return aztroClient.getAztro(signs.get(signsIndex), days.get(daysIndex));
    }
}