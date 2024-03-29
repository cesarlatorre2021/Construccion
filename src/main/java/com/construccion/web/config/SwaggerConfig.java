package com.construccion.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.construccion.controller"))
	            .paths(PathSelectors.regex("/.*"))
	            .build().apiInfo(apiEndoPointInfo());
	}
	 
	private ApiInfo apiEndoPointInfo() {
		return new ApiInfoBuilder().title("Api de gestion de solicitudes para contrucción")
				.description("Servicios para la gestion de solicitudes para la construccion")
				.license("Apache 2.0")
				.version("1.0.0")
				.licenseUrl("http://www.apache.org/licences/LICENSE-2.0.html")
				.build();
	}

}
