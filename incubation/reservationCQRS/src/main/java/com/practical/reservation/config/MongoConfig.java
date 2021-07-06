package com.practical.reservation.config;

import com.practical.reservation.converters.LocalDateToDateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import static java.util.Arrays.asList;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions customConversions(){
        return new MongoCustomConversions(asList(
          new LocalDateToDateConverter()
        ));
    }


}
