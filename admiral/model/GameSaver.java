package admiral.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author jon
 */
public class GameSaver
{
    public static String AUTO_SAVE_LOCATION = "auto.save";

    private final Runnable saver = new Runnable() {               
        @Override
        public void run()
        {
            try
            {
                saveGame();
            }
            catch(CannotSaveException e)
            {
                System.out.println(e.getMessage());
                //TODO: Work out what the fuck to do here. This is hardly giving up gracefully!
                //      Extend Runnable to pass a message back?
            }
        }
    };
    
    //private static final ExecutorService executor = Executors.newFixedThreadPool(1);
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    private final GameState state;

    public GameSaver(GameState state) {
        this.state = state;
    }

    public void save() {
        executor.submit(saver);
    }

    public static void close() {
        executor.shutdown();
    }    

    /**
     * Save the game to disk
     * TODO: Accept an argument and use autoSave, chooseSaveLocation etc methods to control location
     * @throws CannotSaveException if a file cannot be found, opened or created
     */
    public void saveGame() throws CannotSaveException
    {
        //TODO: Make a snapshot?
        //TODO: Bonus: Making a snapshot means I can choose only nearby/mission related vessels, and non-default harbour/regions.
        //TODO: Save performance vs save size. Can reduce disk space by using less, but it takes more processing to choose what to save.
        //      Then again, saving more stuff takes more time anyway
        //TODO: SAVE INDIVIDUAL VESSELS - then re-populate lists on load. Solves problems with cloning items in an arraylist.

        try
        {            
            //TODO: Use a given location. Probably means I need to extend Runnable above to accept parameters            
            SaveFile saveFile = new SaveFile(GameSaver.AUTO_SAVE_LOCATION);
            
            FileOutputStream saveStream = new FileOutputStream(saveFile.getFile());
            ObjectOutputStream save = new ObjectOutputStream(saveStream);
            save.writeObject(GameState.getInstance());
            save.close();
            //GameState.LAST_SAVE = GameUtilities.getTime();
        }
        catch(CannotCreateFileException e)
        {
            throw new CannotSaveException("Cannot create file");
        }
        catch(FileNotFoundException e)
        {            
            throw new CannotSaveException("File not found");            
            //GameUtilities.exceptionDebug(e);
        }
        catch(IOException e)
        {
            throw new CannotSaveException("IO Exception");
            //GameUtilities.exceptionDebug(e);
        }
    }

}