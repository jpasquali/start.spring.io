package com.springone.generation.contributor;

import static com.google.common.base.CaseFormat.LOWER_HYPHEN;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.contributor.ProjectContributor;

/**
 * @author Joachim Pasquali
 */
public class ProjectVariableContributor implements ProjectContributor {

	private static final String TEMPLATE_NAME = "project-vars";
	private static final String FILENAME = "project-vars.yml";
	private static final String NAME = "name";

	private final MustacheTemplateRenderer renderer;
	private final ProjectDescription description;

	public ProjectVariableContributor(final ProjectDescription pDescription, final MustacheTemplateRenderer pTemplateRenderer) {
		this.description = pDescription;
		this.renderer = pTemplateRenderer;
	}

	@Override
	public void contribute(
			final Path pProjectRoot) throws IOException {
		final Path file = Files.createFile(pProjectRoot.resolve(FILENAME));
		final String name = UPPER_CAMEL.to(LOWER_HYPHEN, this.description.getArtifactId());
		final Map<String, String> projectVarMap = Collections.singletonMap(NAME, name);
		Files.write(file, this.renderer.render(TEMPLATE_NAME, projectVarMap).getBytes());
	}
}
