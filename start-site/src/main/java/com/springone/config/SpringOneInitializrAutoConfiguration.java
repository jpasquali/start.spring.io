package com.springone.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springone.controller.SpringOneProjectGenerationController;
import com.springone.controller.SpringOneWebProjectRequest;
import com.springone.description.SpringOneProjectRequestToDescriptionConverter;

import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.web.project.ProjectGenerationInvoker;

/**
 * @author Joachim Pasquali
 */
@Configuration
public class SpringOneInitializrAutoConfiguration {

	@Bean
	public SpringOneProjectGenerationController projectGenerationController(
			final InitializrMetadataProvider pMetadataProvider,
			final ApplicationContext pApplicationContext) {

		final ProjectGenerationInvoker<SpringOneWebProjectRequest> projectGenerationInvoker = new ProjectGenerationInvoker<>(pApplicationContext,
				new SpringOneProjectRequestToDescriptionConverter());
		return new SpringOneProjectGenerationController(pMetadataProvider, projectGenerationInvoker);
	}
}
