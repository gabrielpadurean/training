package org.personal.service;

import org.personal.client.NasaClient;
import org.personal.domain.APOD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class NasaService {
    private int NASA_APOD_MIN_YEAR = 1995;
    private int NASA_APOD_MIN_MONTH = 6;
    private int NASA_APOD_MIN_DAY = 16;

    @Value("${nasa.apod.max}")
    private int maxRandomApods;

    @Autowired
    private NasaClient nasaClient;


    public APOD randomAPOD() {
        return nasaClient.getAPOD(getRandomApodDate());
    }

    public Collection<APOD> randomAPODs() {
        int randomNumberOfApods = ThreadLocalRandom.current().nextInt(1, maxRandomApods + 1);
        Collection<APOD> randomAPODs = new HashSet<>();

        for (int i = 0; i < randomNumberOfApods; i++) {
            randomAPODs.add(nasaClient.getAPOD(getRandomApodDate()));
        }

        return randomAPODs;
    }

    private LocalDate getRandomApodDate() {
        LocalDate startDate = LocalDate.of(NASA_APOD_MIN_YEAR, NASA_APOD_MIN_MONTH, NASA_APOD_MIN_DAY);
        LocalDate endDate = LocalDate.now().minusDays(1);

        long days = ChronoUnit.DAYS.between(startDate, endDate);

        return startDate.plusDays(ThreadLocalRandom.current().nextLong(days));
    }
}