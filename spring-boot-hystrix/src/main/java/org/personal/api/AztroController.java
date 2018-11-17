package org.personal.api;

import org.personal.domain.Aztro;
import org.personal.service.AztroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class AztroController {
    @Autowired
    private AztroService aztroService;


    @RequestMapping(value = "/aztro", method = GET)
    public Aztro getAztro() {
        return aztroService.getAztro();
    }
}