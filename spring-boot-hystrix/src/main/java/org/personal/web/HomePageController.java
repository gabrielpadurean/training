package org.personal.web;

import org.personal.service.AztroService;
import org.personal.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomePageController {
    private final static String HOME_PAGE = "homePage";

    @Autowired
    private NasaService nasaService;

    @Autowired
    private AztroService aztroService;


    @RequestMapping(value = "/", method = GET)
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(HOME_PAGE);
        modelAndView.addObject("apods", nasaService.randomAPODs());
        modelAndView.addObject("aztro", aztroService.getAztro());

        return modelAndView;
    }
}