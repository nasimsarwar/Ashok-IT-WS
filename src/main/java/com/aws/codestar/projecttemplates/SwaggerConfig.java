package com.aws.codestar.projecttemplates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.LinkDiscoverer;
import org.springframework.hateoas.LinkDiscoverers;
import org.springframework.plugin.core.SimplePluginRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	  Contact contact = new Contact(
	            "Nasim Sarwar",
	            "http://www.ashokit.com", 
	            "nasim@ashokit.com"
	    );
	
	  List<VendorExtension> vendorExtensions = new ArrayList<>();
	  ApiInfo apiInfo = new ApiInfo(
				"Ashok-IT RESTful Web Service documentation",
				"This pages documents  Ashok-IT RESTful Web Service endpoints", 
				"1.0",
				"http://www.ashokit.in/service.html", 
				contact, 
				"Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0", 
				vendorExtensions);

	@Bean
	public Docket apiDocker() {
		
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.protocols(new HashSet<>(Arrays.asList("HTTP","HTTPs")))
				.apiInfo(apiInfo)
				.select().apis(RequestHandlerSelectors.basePackage("com.aws.codestar.projecttemplates"))
				.paths(PathSelectors.any())
				.build();
		
		
		return docket;
		
		
	}
	/*@Bean
    public LinkDiscoverers discoverers() {
	   List<LinkDiscoverers> plugins = new ArrayList<>();
	   plugins.addAll((Collection<? extends LinkDiscoverers>) new CollectionJsonLinkDiscoverer());
	   return new LinkDiscoverers(SimplePluginRegistry.create());
	   
	   */
	   
	   
	
		   
		   
	   
	   
	   
	   
	  
   }

