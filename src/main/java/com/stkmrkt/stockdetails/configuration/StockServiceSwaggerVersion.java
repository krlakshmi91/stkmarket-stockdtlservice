package com.stkmrkt.stockdetails.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(basePackages = { "com.stkmrkt.stockdetails" })
public class StockServiceSwaggerVersion {

	@Bean
	public Docket stkmrktDatasouceDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.stkmrkt.stockdetails.controller"))
				.paths(PathSelectors.any()).build().pathMapping("/").apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("StockMarket Stock Detail Service").description(
				"Stock Detail service is used to manage stock details of a company.")
				.build();
	}
}
