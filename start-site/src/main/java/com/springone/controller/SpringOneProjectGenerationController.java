package com.springone.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestHeader;

import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.web.controller.ProjectGenerationController;
import io.spring.initializr.web.project.ProjectGenerationInvoker;

/**
 * @author Joachim Pasquali
 */
public class SpringOneProjectGenerationController extends ProjectGenerationController<SpringOneWebProjectRequest> {

	public SpringOneProjectGenerationController(
			final InitializrMetadataProvider pMetadataProvider,
			final ProjectGenerationInvoker<SpringOneWebProjectRequest> pProjectGenerationInvoker) {

		super(pMetadataProvider, pProjectGenerationInvoker);
	}

	@Override
	public SpringOneWebProjectRequest projectRequest(
			@RequestHeader final Map<String, String> pHeaders) {

		final SpringOneWebProjectRequest request = new SpringOneWebProjectRequest();
		request.getParameters().putAll(pHeaders);
		request.initialize(this.getMetadata());
		return request;
	}
}
