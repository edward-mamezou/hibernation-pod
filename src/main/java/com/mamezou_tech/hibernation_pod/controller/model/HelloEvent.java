package com.mamezou_tech.hibernation_pod.controller.model;

public record HelloEvent(String eventId, String podId, String helloVoice, String time) {
}
