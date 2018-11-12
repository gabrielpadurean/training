package org.personal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomePageController {
    private final static String HOME_PAGE = "homePage.html";


    @RequestMapping(value = "/", method = GET)
    public String getHomePage() {
        return HOME_PAGE;
    }
}