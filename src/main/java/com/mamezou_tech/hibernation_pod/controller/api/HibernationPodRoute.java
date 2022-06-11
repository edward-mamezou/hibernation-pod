package com.mamezou_tech.hibernation_pod.controller.api;

import com.mamezou_tech.hibernation_pod.application.HelloProcessor;
import com.mamezou_tech.hibernation_pod.controller.model.HelloEvent;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernationPodRoute extends RouteBuilder {

    private final PodFilter podFilter;

    private final HelloProcessor helloProcessor;

    @Autowired
    public HibernationPodRoute(PodFilter podFilter, HelloProcessor helloProcessor) {
        this.podFilter = podFilter;
        this.helloProcessor = helloProcessor;
    }

    @Override
    public void configure() {
        from("paho:hibernation-pod/hello")
            .unmarshal().json(JsonLibrary.Jackson, HelloEvent.class)
            .filter(podFilter)
            .process(helloProcessor);
    }
}
