package org.personal.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.personal.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.djl.inference.Predictor;
import ai.djl.modality.cv.output.DetectedObjects;
import ai.djl.modality.cv.util.BufferedImageUtils;

@Service
public class DetectionService {
    private static Logger LOG = LoggerFactory.getLogger(DetectionService.class);

	@Autowired
	private Predictor<BufferedImage, DetectedObjects> predictor;
	
	
	public List<Result> detect(String url) {
		List<Result> results = List.of();
		
		try {
			results = predictor
				.predict(getImage(url))
				.items()
				.stream().map(item -> {
					DecimalFormat decimalFormat = new DecimalFormat("#%");
					Result result = new Result();
					
					result.setName(item.getClassName());
					result.setProbability(decimalFormat.format(item.getProbability()));
					
					return result;
				})
				.collect(Collectors.toList());
		} catch (Exception e) {
			LOG.error("Cannot detect objects from url", e);
		}
		
		return results;
	}
	
	private BufferedImage getImage(String url) throws IOException {
		return BufferedImageUtils.fromUrl(url);
	}
}
