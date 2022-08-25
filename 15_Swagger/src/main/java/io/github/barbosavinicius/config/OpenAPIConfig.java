package io.github.barbosavinicius.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

	private final License apiLicense = new License().name("Apache 2.0").url("https://site.da.api/license");

	private final Info apiInfo = new Info().title("RESTful API with Java 18 and Spring Boot 3").version("v1")
										   .description("Complete description about the API")
										   .termsOfService("https://site.da.api/terms").license(apiLicense);

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(apiInfo);
	}
}
