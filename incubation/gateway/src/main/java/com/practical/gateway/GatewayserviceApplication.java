package com.practical.gateway;

import com.practical.gateway.config.SecurityConfig;
import com.practical.gateway.config.SwaggerConfig;
import com.practical.gateway.config.SwaggerRouterFunctionConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@Import({SwaggerConfig.class, SecurityConfig.class, SwaggerRouterFunctionConfiguration.class})
@RestController
public class GatewayserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserviceApplication.class, args);
	}

}
