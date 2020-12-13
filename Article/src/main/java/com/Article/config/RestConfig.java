package com.Article.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.Article.service.Articleservice;

@Component
@ApplicationPath("/api")
public class RestConfig extends ResourceConfig{
	public RestConfig() {
		register(Articleservice.class);
	}

}
