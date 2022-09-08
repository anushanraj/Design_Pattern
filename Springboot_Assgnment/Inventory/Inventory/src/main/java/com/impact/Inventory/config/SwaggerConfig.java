package com.impact.Inventory.config;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.readers.operation.HandlerMethodResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metadata())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/**"))
				.build();
	}

	
	private ApiInfo metadata() {
	return new ApiInfoBuilder()
			.title("Inventory")
			.description("API reference guide for developers")
			.version("1.0")
			.build();	
	}

}
