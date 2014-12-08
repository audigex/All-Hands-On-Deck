package admiral;

import admiral.view.MainWindow;



/**
 * Main class. Doesn't actualy do anything - main method could probably be put into GameController.java
 * Going to keep it like this for now anyway though, in case I end up interacting with the gameInstance.
 * @version 0.0.1
 * @author jon
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //MainWindow view = new MainWindow();
        admiral.GameController gameInstance = new admiral.GameController();
    }

    public static void sleep(int time)
    {
        //GameUtilities.debug("Sleeping for: " + time + "ms");
        try
        {
            Thread.sleep(time);
        }
        catch(Exception e)
        {
            GameUtilities.debug("Couldn't sleep");
        }
    }
}
