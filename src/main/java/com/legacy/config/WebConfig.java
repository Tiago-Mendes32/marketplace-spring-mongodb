package com.legacy.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.legacy.serialization.converter.YamlJackson2HttpMesageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	
	public static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMesageConverter());
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		//Config for QUERY PARAM
		/*configurer.favorParameter(true).
		parameterName("mediaType").
		ignoreAcceptHeader(true).
		useRegisteredExtensionsOnly(false).
		defaultContentType(MediaType.APPLICATION_JSON).
		mediaType("json", MediaType.APPLICATION_JSON).
		mediaType("xml", MediaType.APPLICATION_XML);*/
		
		//Config for HEADER PARAM
		configurer.favorParameter(false).
		ignoreAcceptHeader(false).
		useRegisteredExtensionsOnly(false).
		defaultContentType(MediaType.APPLICATION_JSON).
		mediaType("json", MediaType.APPLICATION_JSON).
		mediaType("xml", MediaType.APPLICATION_XML).
		mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
	}

}
