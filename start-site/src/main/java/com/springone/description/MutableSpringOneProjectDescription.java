package com.springone.description;

import io.spring.initializr.generator.project.MutableProjectDescription;

/**
 * @author Stephane Nicoll
 */
public class MutableSpringOneProjectDescription extends MutableProjectDescription implements SpringOneProjectDescription {

	private String applicationId;

	@Override
	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(
			final String pApplicationId) {
		this.applicationId = pApplicationId;
	}
}
