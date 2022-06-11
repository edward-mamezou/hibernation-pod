package com.mamezou_tech.hibernation_pod.infrastructure;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.InputStream;

public class FileConverter {

    public static void main(String[] args) throws Exception {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("james.mp3")) {
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            AudioInputStream converted = AudioSystem.getAudioInputStream(AudioPlayer.target(ais.getFormat()), ais);
            AudioSystem.write(converted, AudioFileFormat.Type.WAVE, new File("src/test/resources/james.wav"));
        }
    }
}
