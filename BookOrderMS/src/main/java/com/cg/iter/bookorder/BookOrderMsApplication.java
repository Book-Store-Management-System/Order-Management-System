package com.cg.iter.bookorder;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class BookOrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookOrderMsApplication.class, args);
	}
	@Bean
	public Docket SwaggerConfiguration()
	{
		/** Here We need to create instance of Docket to use swagger2 documentation */
		
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.cg.iter.bookorder"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"Book Order Management Api ",
			"Api for Book Order Management"	,
			"1.0",
			"Api endpoints for crud operation",
			new springfox.documentation.service.Contact("Satya Swagatam Panda","satyaswagatam@gmail.com","www.google.com"),
			"Capgemini Bootcamp",
			"using swagger for documentation",
			Collections.emptyList());
	
	
	}
}
