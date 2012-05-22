package admiral.model;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author jon
 */
public class SaveFile
{
    private File file;

    public SaveFile(String path) throws CannotCreateFileException
    {
        this.file = new File(path);

        if(!file.exists())
        {
            try
            {
                // Try creating the file
                file.createNewFile();
            }
            catch(IOException e)
            {                
                System.out.println(e.getMessage());                
                throw new CannotCreateFileException("SaveFile: IOException");
            }
        }
    }

    public File getFile()
    {
        return this.file;
    }    
}
