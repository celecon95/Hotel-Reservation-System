package com.practical.gateway.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;


public class SwaggerResourceHandler implements HandlerFunction {

    private final SwaggerResourcesProvider provider;

    @Autowired
    public SwaggerResourceHandler(SwaggerResourcesProvider resourcesProvider){
        this.provider = resourcesProvider;
    }

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(provider.get()));
    }
}
