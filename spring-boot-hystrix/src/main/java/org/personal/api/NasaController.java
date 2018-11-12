package org.personal.api;

import org.personal.domain.APOD;
import org.personal.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasaController {
    @Autowired
    private NasaService nasaService;


    @RequestMapping("/apod")
    public APOD getPerson() {
        return nasaService.randomAPOD();
    }
}