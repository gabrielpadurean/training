package org.personal.service;

import org.personal.client.NasaClient;
import org.personal.domain.APOD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class NasaService {
    @Autowired
    private NasaClient nasaClient;


    public APOD randomAPOD() {
        LocalDate startDate = LocalDate.of(1995, 6, 16);
        LocalDate endDate = LocalDate.now().minusDays(1);

        long days = ChronoUnit.DAYS.between(startDate, endDate);

        return nasaClient.getAPOD(startDate.plusDays(ThreadLocalRandom.current().nextLong(days)));
    }
}