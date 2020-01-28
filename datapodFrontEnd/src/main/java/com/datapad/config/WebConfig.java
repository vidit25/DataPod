package com.datapad.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer
{
   @Value("${web.assets.pattern}")
   private String assetsPattern;

   @Value("${web.assets.directory}")
   private String assetsDirectory;
   
   @Value("${web.jsp.filePrefix}")
   private String jspFilePrefix;
   
   @Value("${web.jsp.fileSuffix}")
   private String jspFileSuffix;

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry)
   {
       registry
         .addResourceHandler(assetsPattern)
         .addResourceLocations(assetsDirectory);
   }
   
   @Bean
   public InternalResourceViewResolver viewResolver()
   {
      InternalResourceViewResolver viewResolver 
                         = new InternalResourceViewResolver();
      viewResolver.setViewClass(JstlView.class);
      viewResolver.setPrefix(jspFilePrefix);
      viewResolver.setSuffix(jspFileSuffix);
      
      return viewResolver;
   }
}
