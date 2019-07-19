package com.rfa.employee.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Import(BeanValidatorPluginsConfiguration.class) // dari swagger
public class SwaggerConfig {

//docket : untuk inisialisasi swagger nya. swagger ingin membaca class apa, path apa
//akan membaca semua package yg ada di parent com.rfa.employee = regex
//apiInfo: akan memanggil metaInfo
	@Bean // kalo ga diinisialisasi dia ga akan membaca apa yg kita minta
	public Docket eksadAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.rfa.employee")) // package nya harus benar
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo())
				.tags(
					new Tag("Division", "Division Management API"),
					new Tag("Employee", "Employee Management API"),
					new Tag("Data Manipulation API", ""),
					new Tag("Get Data API", "")
						)
				;	
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo (
				"Employee Data Management REST API",  // judul API
				"Rest API Collection for Employee Data Management", //deskripsi
				"1.0.0", 
				"http://google.com", 
				new Contact("Achmad Fulan", "http://www.fulan.com", "fulan@gmail.com"), //contact developer
				"Fulan 2.0", 
				"http://www.google.com/license", 
				Collections.emptyList()); // vendor extension.dikasih nilai kosong aja. masih belum banyak yg pakai
		return apiInfo;
	}


}
