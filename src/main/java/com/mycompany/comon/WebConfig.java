package com.mycompany.comon;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author gduvinage
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{
    

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("PUT","POST","GET","OPTIONS","DELETE")
                ;
    }
    
}
