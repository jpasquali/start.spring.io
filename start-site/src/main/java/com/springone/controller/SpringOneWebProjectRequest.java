package com.springone.controller;

import io.spring.initializr.web.project.WebProjectRequest;

/**
 * @author Joachim Pasquali
 */
public class SpringOneWebProjectRequest extends WebProjectRequest {

	private String applicationId;

	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(
			final String pApplicationId) {
		this.applicationId = pApplicationId;
	}
}
