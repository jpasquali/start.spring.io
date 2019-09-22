package com.springone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.metadata.InitializrMetadataBuilder;
import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.metadata.InitializrProperties;
import io.spring.initializr.web.support.DefaultInitializrMetadataProvider;
import io.spring.initializr.web.support.InitializrMetadataUpdateStrategy;

@Configuration
public class AddDependencyConfig {

	@Autowired
	@Qualifier("initializr-io.spring.initializr.metadata.InitializrProperties")
	private InitializrProperties initializrProperties;

	@Bean
	@ConfigurationProperties("springone")
	public InitializrProperties springOneProperties() {
		return new InitializrProperties();
	}

	@Bean
	public InitializrMetadataProvider customInitializrMetadataProvider(
			final InitializrMetadataUpdateStrategy metadataUpdateStrategy) {
		final InitializrMetadata metaData = InitializrMetadataBuilder.fromInitializrProperties(this.springOneProperties()).withInitializrProperties(
				this.initializrProperties, true).build();
		return new DefaultInitializrMetadataProvider(metaData, metadataUpdateStrategy);
	}

}
