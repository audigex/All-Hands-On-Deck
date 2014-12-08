package admiral.model;

import admiral.Main;
import java.io.*;

/**
 *
 * @author jon
 */
public class GameLoader
{    
    //GameSaver.AUTO_SAVE_LOCATION

    private FileInputStream loadStream;

    public GameLoader() throws NoAutoSaveFileException
    {        
        try
        {
            this.init(GameSaver.AUTO_SAVE_LOCATION);
        }
        catch(CannotLoadException e)
        {
            //GameUtilities.exceptionDebug(e);
            throw new NoAutoSaveFileException("No AutoSave file found");
        }
    }
    public GameLoader(String saveLocation) throws CannotLoadException
    {
        this.init(saveLocation);
    }

    public final void init(String saveLocation) throws CannotLoadException
    {        
        try
        {            
            SaveFile saveFile = new SaveFile(saveLocation);                        
            this.loadStream = new FileInputStream(saveFile.getFile());            
        }
        catch(FileNotFoundException e)
        {
            //GameUtilities.exceptionDebug(e);
            throw new CannotLoadException("GameLoader: File not found");
        }
        catch(CannotCreateFileException e)
        {
            throw new CannotLoadException("GameLoader: Cannot create file");
        }
    }
    
    /**
     * Loads the game from disk
     * Currently only allows one save game
     * TODO: Accept an argument and use autoLoad, chooseLoadLocation etc methods to control location
     * @throws CannotLoadException when the game cannot be loaded for any reason
     * @return the loaded game
     */
    public GameState load() throws CannotLoadException
    {
        try
        {            
            ObjectInputStream gameRestore = new ObjectInputStream(this.loadStream);                                  
            Object obj = gameRestore.readObject();              
            GameState newState = (GameState) obj;            
           
            gameRestore.close();            

            return newState;
            
        }
        catch (ClassNotFoundException e)
        {
            //GameUtilities.exceptionDebug(e);
            throw new CannotLoadException("GameLoader: No save file contents");
        }
        catch(FileNotFoundException e)
        {
            //GameUtilities.exceptionDebug(e);
            throw new CannotLoadException("GameLoader: File not found");
        }
        catch(IOException e)
        {
            //GameUtilities.exceptionDebug(e);        
            System.out.println(e.getMessage());
            System.exit(0);
            throw new CannotLoadException("GameLoader: IOException - no object to read or problem reading object.");          
        }
        
    } 

}
