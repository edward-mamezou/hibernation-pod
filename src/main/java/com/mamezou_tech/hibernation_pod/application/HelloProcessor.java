package com.mamezou_tech.hibernation_pod.application;

import com.mamezou_tech.hibernation_pod.controller.model.HelloEvent;
import com.mamezou_tech.hibernation_pod.infrastructure.AudioPlayer;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class HelloProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(HelloProcessor.class);

    private final String audio;

    public HelloProcessor(String audio) {
        this.audio = audio;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getMessage();
        HelloEvent event = message.getBody(HelloEvent.class);
        AudioPlayer player = new AudioPlayer(audio);
        player.playAudio(new URL(event.helloVoice()));
    }
}
