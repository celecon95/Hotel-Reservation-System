package com.practical.gateway.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.DispatcherHandler;

@Configuration
public class FilterConfig {

    @Bean
    public SwaggerHeaderFilter swaggerHeaderFilter(){
        return new SwaggerHeaderFilter();
    }

    @Bean
    public AuthenticationFilter authenticationFilter(){ return new AuthenticationFilter();}

    @Bean
    public DispatcherHandler dispatcherHandler(){
        return new DispatcherHandler();
    }
}
