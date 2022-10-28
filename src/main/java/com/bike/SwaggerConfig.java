package com.bike;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
		
	@Bean
	public Docket swagger2Config() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(PathSelectors.ant("/bike/*"))
				.build()
				.apiInfo(new ApiInfo("Bike API", "Bike management api", "1.0", "http://localhost:8082/swagger-ui/",
						new Contact("Velmurugan", "http://localhost:8082/swagger-ui/", "velmurugan326551@gmail.com"), "Open Source", 
						"http://localhost:8082/swagger-ui/", Collections.emptyList()));
	}
}
