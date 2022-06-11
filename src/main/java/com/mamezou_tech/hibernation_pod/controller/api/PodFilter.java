package com.mamezou_tech.hibernation_pod.controller.api;

import com.mamezou_tech.hibernation_pod.controller.model.HelloEvent;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PodFilter implements Predicate {

    private final String podId;

    public PodFilter(@Value("${hibernation.pod.id}") String podId) {
        this.podId = podId;
    }

    @Override
    public boolean matches(Exchange exchange) {
        Message message = exchange.getMessage();
        HelloEvent event = message.getBody(HelloEvent.class);
        return podId.equals(event.podId());
    }
}
