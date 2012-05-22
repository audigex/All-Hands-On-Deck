package admiral;

/**
 *
 * @author jon
 */
public class GameUtilities
{
    private void GameUtilites()
    {
        //Do nothing
    }

    /**
     * Print/store or whatever else we need to do with a debug message
     */
    public static void debug(Object message)
    {
        if(GameController.DEBUG)
        {
            System.out.println(message);
        }
    }

    public static double getTime()
    {
        double time = System.nanoTime();
        time = time / GameController.NANOS_PER_MILLIS;
        return time;
    }
}
