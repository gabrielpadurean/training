package org.personal.web;

import java.util.List;

import org.personal.domain.Result;
import org.personal.service.DetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetectionController {
	@Autowired
	private DetectionService detectionService;
	
	
	@GetMapping("/detect")
	public List<Result> detect(@RequestParam String url) {
		return detectionService.detect(url);
	}
}
