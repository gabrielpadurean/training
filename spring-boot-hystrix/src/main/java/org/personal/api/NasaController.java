package org.personal.api;

import org.personal.domain.APOD;
import org.personal.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class NasaController {
    @Autowired
    private NasaService nasaService;


    @RequestMapping(value = "/apod", method = GET)
    public APOD getAPOD() {
        return nasaService.randomAPOD();
    }

    @RequestMapping(value = "/apods", method = GET)
    public Collection<APOD> getAPODs() {
        return nasaService.randomAPODs();
    }
}