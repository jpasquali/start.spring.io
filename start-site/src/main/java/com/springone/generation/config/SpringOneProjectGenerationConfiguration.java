package com.springone.generation.config;

import org.springframework.context.annotation.Bean;

import com.springone.description.SpringOneProjectDescription;
import com.springone.generation.contributor.SpringOneApplicationPropertiesContributor;

import io.spring.initializr.generator.buildsystem.maven.MavenBuildSystem;
import io.spring.initializr.generator.condition.ConditionalOnBuildSystem;
import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;

/**
 * @author Joachim Pasquali
 */
@ProjectGenerationConfiguration
public class SpringOneProjectGenerationConfiguration {

	@Bean
	@ConditionalOnBuildSystem(MavenBuildSystem.ID)
	public SpringOneApplicationPropertiesContributor appPropsContributor(
			final SpringOneProjectDescription pDescription,
			final MustacheTemplateRenderer pTemplateRenderer) {

		return new SpringOneApplicationPropertiesContributor(pDescription, pTemplateRenderer);
	}
}
