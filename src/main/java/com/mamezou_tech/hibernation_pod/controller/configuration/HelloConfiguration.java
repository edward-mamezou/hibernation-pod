package com.mamezou_tech.hibernation_pod.controller.configuration;

import com.mamezou_tech.hibernation_pod.application.HelloProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {

    @Value("${hibernation.pod.audio}")
    private String audio;

    @Bean
    public HelloProcessor getHelloProcessor() {
        return new HelloProcessor(audio);
    }
}
