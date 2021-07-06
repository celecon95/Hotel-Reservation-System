package com.practical.guest.config;

/*
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.mongo.DefaultMongoTemplate;
import org.axonframework.mongo.MongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.mongo.eventsourcing.eventstore.MongoFactory;
import org.axonframework.mongo.eventsourcing.eventstore.documentperevent.DocumentPerEventStorageStrategy;
import org.axonframework.mongo.eventsourcing.tokenstore.MongoTokenStore;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.upcasting.event.EventUpcasterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class AxonConfig {

   */
/* @Bean
    public EventStorageEngine storageEngine(EventUpcasterChain upcasterChain) {
        return MongoEventStorageEngine.builder()
                .eventSerializer(eventSerializer())
                .snapshotSerializer(eventSerializer())
                .mongoTemplate(mongoTemplate)
                .upcasterChain(upcasterChain)
                .storageStrategy(new DocumentPerEventStorageStrategy())
                .build();*//*


    @Value("${spring.data.mongodb.host:127.0.0.1}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port:27017}")
    private int mongoPort;

    @Value("${spring.data.mongodb.database:test}")
    private String mongoDatabase;

    @Bean
    public TokenStore tokenStore(Serializer serializer) {
        return new MongoTokenStore(axonMongoTemplate(), serializer);
    }

    @Bean
    public EventStorageEngine eventStorageEngine(MongoClient client) {
        return new MongoEventStorageEngine(new DefaultMongoTemplate(client));
    }

    @Bean
    public MongoTemplate axonMongoTemplate() {
        return new DefaultMongoTemplate(mongoClient(), mongoDatabase);
    }

    @Bean
    public MongoClient mongoClient() {
        MongoFactory mongoFactory = new MongoFactory();
        mongoFactory.setMongoAddresses(Collections.singletonList(new ServerAddress(mongoHost, mongoPort)));
        return mongoFactory.createMongo();
    }
}*/
