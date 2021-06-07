package Main;

import javax.sound.sampled.*;
import java.io.IOException;

/*
 * Main class, runs the main method and runs a background music for the entertainment of the user. 
 */
public class Main {
	
	/*
	 * Main method, starts  the program by calling on the constructor of MainFrame
	 *  and starts the music of the program.
	 */
    public static void main(String[] args) {
        FullMessages.generateFullMessages();
        Main x = new Main();
        x.SoundClipTest();
        new MainFrame();
    }

    /*
     * Runs a predetermine sound clip behind the program just because why not.
     */
    public void SoundClipTest() {

        try {
            java.net.URL url = this.getClass().getResource("(Free) Aggressive Trap Beat - Hacker Rap Instrumental Music 2017 DiKadia #Instrumentals.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        
    }

}

