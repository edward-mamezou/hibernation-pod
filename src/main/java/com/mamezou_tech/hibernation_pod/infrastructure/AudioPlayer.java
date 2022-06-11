package com.mamezou_tech.hibernation_pod.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class AudioPlayer {

    private final Optional<Mixer.Info> maybeMixerInfo;

    static AudioFormat target(AudioFormat format) {
        return new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                format.getSampleRate(),
                16,
                format.getChannels(),
                format.getChannels() * 2,
                format.getSampleRate(),
                false
        );
    }

    private final static Logger logger = LoggerFactory.getLogger(AudioPlayer.class);

    public AudioPlayer(String name) {
        Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
        Mixer.Info mixer = null;
        for (Mixer.Info info : mixerInfo) {
            logger.info(info.getName());
            if (name.equals(info.getName())) {
                mixer = info;
            }
        }
        this.maybeMixerInfo = Optional.ofNullable(mixer);
    }

    public void playAudio(URL url) {
        maybeMixerInfo.ifPresent(mixerInfo -> {
            try {
                Mixer mixer = AudioSystem.getMixer(mixerInfo);
                AudioInputStream in = AudioSystem.getAudioInputStream(url);
                play(mixer, in, in.getFormat());
            } catch (Exception e) {
                logger.error("", e);
            }
        });
    }

    private void play(Mixer mixer, AudioInputStream dataIn, AudioFormat target) throws LineUnavailableException, IOException {
        byte[] buffer = new byte[4096];
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, target);
        SourceDataLine line = (SourceDataLine) mixer.getLine(info);
        if (line != null) {
            line.open();

            line.start();
            int nBytesRead = 0, nBytesWritten = 0;
            while (nBytesRead != -1) {
                nBytesRead = dataIn.read(buffer, 0, buffer.length);
                if (nBytesRead != -1) {
                    nBytesWritten = line.write(buffer, 0, nBytesRead);
                }
            }

            line.drain();
            line.stop();
            line.close();

            dataIn.close();
        }
    }
}
