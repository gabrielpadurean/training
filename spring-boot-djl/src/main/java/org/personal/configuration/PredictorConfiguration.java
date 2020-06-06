package org.personal.configuration;
import java.awt.image.BufferedImage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ai.djl.Application;
import ai.djl.inference.Predictor;
import ai.djl.modality.cv.output.DetectedObjects;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelZoo;

@Configuration
public class PredictorConfiguration {
    private static Logger LOG = LoggerFactory.getLogger(PredictorConfiguration.class);

	private static final String BACKBONE = "backbone";
	
	private static final String BACKBONE_1 = "mobilenet1.0";
	private static final String BACKBONE_2 = "resnet50";
	
	
	@Bean
	public Criteria<BufferedImage, DetectedObjects> buildPredictorCriteria() {
		return Criteria.builder()
				.optApplication(Application.CV.OBJECT_DETECTION)
				.setTypes(BufferedImage.class, DetectedObjects.class)
				.optFilter(BACKBONE, BACKBONE_1)
				.build();
	}
	
	@Bean
	public Predictor<BufferedImage, DetectedObjects> buildPredictor(Criteria<BufferedImage, DetectedObjects> criteria) {
		Predictor<BufferedImage, DetectedObjects> predictor = null;

		try {
			predictor = ModelZoo.loadModel(criteria).newPredictor();
		} catch (Exception e) {
			LOG.error("Cannnot create the predictor", e);
		}
		
		return predictor;
	}
}