package com.mamezou_tech.hibernation_pod.infrastructure;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

public class AudioPlayerTests {

    private final String name = "default [default]"; //"Default Audio Device";

    @Test
    void playAudio() throws IOException {
        AudioPlayer audioPlayer = new AudioPlayer(name);
        audioPlayer.playAudio(new URL("file:///tmp/james.wav"));
    }
}
