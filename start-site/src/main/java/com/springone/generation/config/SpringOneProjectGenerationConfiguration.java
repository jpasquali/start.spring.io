package com.springone.generation.config;

import org.springframework.context.annotation.Bean;

import com.springone.generation.contributor.ProjectVariableContributor;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;

/**
 * @author Joachim Pasquali
 */
@ProjectGenerationConfiguration
public class SpringOneProjectGenerationConfiguration {

	@Bean
	public ProjectVariableContributor projectVariableContributor(
			final ProjectDescription description,
			final MustacheTemplateRenderer templateRenderer) {
		return new ProjectVariableContributor(description, templateRenderer);
	}
}
