package com.cognizant.accountservice;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cognizant.accountservice.controller.AccountController;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import static springfox.documentation.builders.PathSelectors.regex;


@Slf4j
@SpringBootApplication
@EnableFeignClients
@Configuration
@EnableSwagger2
public class AccountserviceApplication {

	//  gahsd private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	public static void main(String[] args) {
		SpringApplication.run(AccountserviceApplication.class, args);
		log.info("Account microservice started....");
	}

	/*
	 * Adding Swaggar2 REST API Documentation bean
	 */
	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cognizant.accountservice.controller"))
				.build().apiInfo(apiInfo());

	}

//.paths(PathSelectors.ant("/account-ms/*"))	
	private ApiInfo apiInfo() {
		return new ApiInfo("Account Management Service", "Retail Banking Project", "API", "Terms of service",
				new Contact("Peoples' Bank", "", "abc@email.com"), "License of API", "", Collections.emptyList());
	}

}
