package ci553.happyshop.utility;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SoundManager {
    public static void playSound(String filename) {
        try {
            // Finding the sound file
            InputStream stream =
                    SoundManager.class.getResourceAsStream("/sounds/" + filename);

            // If sound not found, print error
            if (stream == null) {
                System.err.println("Sound not found: " + filename);
                return;
            }
            // Loading and preparing the sound
            BufferedInputStream bufferedStream = new BufferedInputStream(stream);
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(bufferedStream);

            // Play the sound
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            // Allow background music to loop
            if (filename.equals("storeambience.wav")){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            clip.start();
        }
        // Catch exceptions
        catch (UnsupportedAudioFileException |
                 IOException |
                 LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    // Play a clicking sound for general buttons
    public static void playClick() {
        playSound("clicksoundeffect.wav");
    }
    // Play a "cha ching" sound when checking out
    public static void playSuccess() {
        playSound("chaching.wav");
    }

    public static void playError(){
        playSound("error.wav");
    }

    public static void playAmbience(){
        playSound("storeambience.wav");
    }

}
