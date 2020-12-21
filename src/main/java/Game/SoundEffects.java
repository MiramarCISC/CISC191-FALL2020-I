package Game;
/**
 * @author  Oliver Ortiz
 * @description this is the ode behind the sound effects.
 */
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SoundEffects
{
    private String filename;
    private AdvancedPlayer player;
    private Player sfx;
    private boolean loop;
    public SoundEffects(String _filename, boolean loop) //constructor takes file name
    {
        this.filename = _filename;
        this.loop = loop;
    }

    public void close()
    {
        if(player != null)
        {
            player.close();
        }
    }

    //play the file to the sound card
    public void play() {
        try {
            do {
                System.out.println("playing file: " + filename);
                player = new AdvancedPlayer(getClass().getClassLoader().getResourceAsStream(filename));
            } while (loop);
        } catch ( Exception e) {
            System.err.println("problem playing file: " + filename);
            e.printStackTrace();
        }

         new Thread () {
        public void run() {
            try {
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }.start();
    }

}

