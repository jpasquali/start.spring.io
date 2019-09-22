package com.springone.description;

import com.springone.controller.SpringOneWebProjectRequest;

import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.web.project.DefaultProjectRequestToDescriptionConverter;
import io.spring.initializr.web.project.ProjectRequestToDescriptionConverter;

/**
 * @author Stephane Nicoll
 */
public class SpringOneProjectRequestToDescriptionConverter implements ProjectRequestToDescriptionConverter<SpringOneWebProjectRequest> {

	@Override
	public ProjectDescription convert(
			final SpringOneWebProjectRequest pRequest,
			final InitializrMetadata pMetadata) {

		final MutableSpringOneProjectDescription description = new MutableSpringOneProjectDescription();
		new DefaultProjectRequestToDescriptionConverter().convert(pRequest, description, pMetadata);

		description.setApplicationId(pRequest.getApplicationId());
		return description;
	}
}
