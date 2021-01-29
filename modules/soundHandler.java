package modules;

/*
    This audio system only takes in .wav files due to java limitations. 
    The reason that this method was used is because I didn't want to import code from other people that I couldn't understand.

    This method of playing audio files is from JavaTutorials101:
        This video describes how the AudioSystem works 
        https://www.youtube.com/watch?v=QVrxiJyLTqU

    Note:
        The sound system only works on specific IDE's. A lot of features are taken away from the program in IntelliJ IDEA. 
        Features such as clear screen and
        sound support are not there.
*/

// Used for getting the path and the file of the clip
import java.io.File;
// Used for getting the audio from the file
import javax.sound.sampled.AudioSystem;
// Used for playing the sound as a audio clip
import javax.sound.sampled.Clip;

// Sound Handler Class
public class soundHandler {

    /* This constructor is here because according to SonarLint Rules,
        Utility classes, which are collections of static members, are not meant to be instantiated. 
        Even abstract utility classes, which can be extended, should not have public constructors.
        Java adds an implicit public constructor to every class which does not define at least one explicitly. 
        Hence, at least one non-public constructor should be defined.
    */
    private soundHandler() {
        throw new IllegalStateException("Utility class");
      }

    /**
     * Plays a sound according to the File passed as its first parameter
     * This method is static because it will only be playing the sound that it's given.
     * 
     * @param _audioFile The File that should be played
     * @param yield Whether to yield the program
     */
    //
    public static void playSound(File _audioFile, boolean yield){
        // This is in a try statement in case the file does not exist
        try {
            // Obtains a clip that can be used for playing back an audio file or an audio stream.
            Clip clip = AudioSystem.getClip();
            // Get the audioFile from AudioInputStream and open it as a audio clip
            clip.open(AudioSystem.getAudioInputStream(_audioFile));
            // Start playing the clip
            clip.start();

            // Check if the audio should be yielded
            if (yield){
                // Yield until the sound finishes playing
                // Thread.sleep takes milliseconds, 1 microsecond = 1000 millisecond.
                Thread.sleep(clip.getMicrosecondLength()/1000);
            }

        // If the program does not find the audio file
        } catch (Exception e){
            // Print in the console what audio errored
            util.print("Error: Unable to play audio " + _audioFile.getName()+"\n"+e.getMessage());
        }
    }
}
