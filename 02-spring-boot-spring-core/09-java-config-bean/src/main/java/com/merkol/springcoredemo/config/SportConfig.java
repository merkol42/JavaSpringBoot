package com.merkol.springcoredemo.config;

import com.merkol.springcoredemo.common.Coach;
import com.merkol.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") // "aquatic" custom bean id. bu id kullanarak injection gerçekleşebilir.
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
