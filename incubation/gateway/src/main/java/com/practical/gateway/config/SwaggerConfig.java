package com.practical.gateway.config;

import com.practical.gateway.swagger.SwaggerResourceController;
import com.practical.gateway.swagger.SwaggerResourceHandler;
import com.practical.gateway.swagger.SwaggerSecurityHandler;
import com.practical.gateway.swagger.SwaggerUiHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig{

    @Bean
    public SwaggerResourceController swaggerResourceController(){
        return new SwaggerResourceController();
    }

    @Bean
    public SwaggerResourceHandler swaggerResourceHandler(SwaggerResourceController swaggerResourceController){
        return new SwaggerResourceHandler(swaggerResourceController);
    }

    @Bean
    public SwaggerSecurityHandler swaggerSecurityHandler(){
        return new SwaggerSecurityHandler();
    }

    @Bean
    public SwaggerUiHandler swaggerUiHandler(){
        return new SwaggerUiHandler();
    }
}
