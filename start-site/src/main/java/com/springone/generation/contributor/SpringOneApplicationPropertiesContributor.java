package com.springone.generation.contributor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import com.springone.description.SpringOneProjectDescription;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.contributor.ProjectContributor;

/**
 * @author Joachim Pasquali
 */
public class SpringOneApplicationPropertiesContributor implements ProjectContributor {

	private static final String TARGET_RESOURCE_PATH = "src/main/resources/application.properties";
	private static final String DEFAULT_APP_ID = "0000";
	private static final String COMPANY_APP_ID = "companyAppId";
	private static final String TEMPLATE_NAME = "application-properties";

	private final SpringOneProjectDescription description;
	private final MustacheTemplateRenderer renderer;

	public SpringOneApplicationPropertiesContributor(
			final SpringOneProjectDescription pDescription,
			final MustacheTemplateRenderer pTemplateRenderer) {
		this.description = pDescription;
		this.renderer = pTemplateRenderer;
	}

	@Override
	public void contribute(
			final Path pProjectRoot) throws IOException {

		final Path output = pProjectRoot.resolve(TARGET_RESOURCE_PATH);
		if (!Files.exists(output)) {
			Files.createDirectories(output.getParent());
			Files.createFile(output);
		}

		// get applicationId or DEFAULT
		final String appId = Optional.ofNullable(this.description.getApplicationId()).orElse(DEFAULT_APP_ID);

		final Map<String, String> projectVarMap = Collections.singletonMap(COMPANY_APP_ID, appId);
		final String content = this.renderer.render(TEMPLATE_NAME, projectVarMap);
		Files.write(output, content.getBytes(), StandardOpenOption.APPEND);
	}

	@Override
	public int getOrder() {
		return 100;
	}
}
