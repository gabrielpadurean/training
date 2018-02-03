package org.personal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gabi
 */
@Controller
public class HomePageController {
	
	@RequestMapping("/")
    @ResponseBody
	public String getHomePage() {
    	return "Welcome!";
	}
}