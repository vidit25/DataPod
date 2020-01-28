package com.datapad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class App extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder appBuilder)
   {
		return appBuilder.sources(App.class);
	}

	public static void main(String[] args) throws Exception
   {
		SpringApplication.run(App.class, args);
	}
}
