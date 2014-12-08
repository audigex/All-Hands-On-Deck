package admiral;

//import java.util.Calendar;
//import java.util.Random;
import admiral.controller.Controller;
import admiral.model.GameSaver;
import admiral.model.GameState;
import admiral.view.MainWindow;
import admiral.view.MainWindowListener;
import java.awt.event.WindowListener;

/**
 *
 * @author jon
 */
public class GameController implements Controller
{
    public final static boolean DEBUG = true;

    public final static String NAME = "Admiral";
    public final static String SLOGAN = "Hoist the mainsail";

    private boolean running = false;
    
    private MainWindow mainWindow;
    private WindowListener mainWindowListener;

    private GameState gameState;    

    //Start time
    private double startTime;
    private int tickCount = 0;
    private double lastTick;
    private int updateCount = 0;
    private double lastUpdate;
    private int renderCount = 0;
    private double lastRender;
    
    //The max FPS we'll bother rendering (don't want to waste time) and gives easy interpolation
    public final static double MAX_FPS = 63.0;
    //The lowest FPS we'll allow before skipping frames
    public final static double MIN_FPS = 20.0;

    //public final double TICK_TIME_IN_MILLIS = 1000.0 / 30.0;

    //public static final int NANOS_PER_S = 1000000000;
    //public static final int MILLIS_PER_S = 1000;
    public final static int NANOS_PER_MILLIS = 1000000;
    
    public final static double MAX_ELAPSE = 1000.0 / MIN_FPS; //If elapsed is less than min, render. If more, skip (up to skip limit)
    public final static double MIN_ELAPSE = 1000.0 / MAX_FPS; //Update. If elapsed is less than max, wait.
    public final static double SKIP_LIMIT = 3;    

    public GameController()
    {        
        this.setupEnvironment();
        this.setupGame();

        this.run();

        this.exit();        
    }

    private void setupEnvironment()
    {
        //this.model = new Model();

        this.mainWindow = new MainWindow();
        this.mainWindowListener = new MainWindowListener(this, this.mainWindow);
        this.mainWindow.addWindowListener(mainWindowListener);

        this.gameState = GameState.getInstance();
        
    }

    private void setupGame()
    {
        this.startTime = GameUtilities.getTime();
        
        this.tickCount = 0;
        this.lastTick = this.startTime;
        this.updateCount = 0;
        this.lastUpdate = this.startTime;
        this.renderCount = 0;
        this.lastRender = this.startTime;
        
        this.running = true;
    }

    /*
     * Test method for now to test timings - need to do this more tidily and link with the threads which need to sleep
     */
    private void sleep(int time)
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

    private double getElapsed(double timestamp)
    {
        double elapsed = GameUtilities.getTime() - timestamp;
        return elapsed;
    }        

    private void run()
    {
        //TODO: Timing is still wrong - I think it's using an old elapsed time to work out whether to wait or maybe to skip
        //      Take a look at how the elapsed times are used and when they're taken... probably gonna need a pen and paper for this one

        //TODO: Might have fixed framerate but at expense of update info
        //      Use a frame elapsed to make sure framerate is right, updated at end of frame
        //      but I need a seperate update elapsed time to make sure objects update properly
        int skippedFrames = 0;
        
        while(this.running)
        { //Start game loop
            this.tickCount++;
            boolean print = false;
            if(this.tickCount % 60 == 0)
            {
                print = true;
            }
            if(print == true) GameUtilities.debug("Tick " + tickCount);

            this.update(/*this.getElapsed()*/);

            double elapsed = this.getElapsed(this.lastTick);
            if(print == true) GameUtilities.debug("Elapsed time: " + elapsed + "ms");

            //Decide whether to render or skip
            if(this.getElapsed(this.lastTick) > GameController.MAX_ELAPSE)
            {
                if(print == true) GameUtilities.debug("Attempt to skip");
                if(skippedFrames > 3)
                {
                    if(print == true) GameUtilities.debug("Late, Skipped too many, render");
                    this.render();
                    skippedFrames = 0;
                }
                else
                {
                    if(print == true) GameUtilities.debug("Late, Skip");
                    skippedFrames++;
                }
            }
            else
            {
                if(print == true) GameUtilities.debug("On time, render");
                this.render();
                skippedFrames = 0;
            }

            elapsed = this.getElapsed(this.lastTick);

            //Decide whether to wait or not            
            if(elapsed <= GameController.MIN_ELAPSE)
            {
                if(print == true) GameUtilities.debug("Wait");
                this.sleep( (int)(GameController.MIN_ELAPSE - elapsed) );
            }
            else
            {
                if(print == true) GameUtilities.debug("Continue");
                GameUtilities.debug(elapsed);
            }

            if(print == true) GameUtilities.debug("--------");

            this.lastTick = GameUtilities.getTime();
        } // End game loop
    }

    /**
     * Calculate new positions of objects, actions of AI and responses to user input
     * Possibly make this asymetrical (fire and forget)?
     * Threads strategy?
     */
    private void update()
    {
        //TODO: Clever things to update as much of the most important stuff as possible but only until we run out of time.
        this.updateCount++;

        //Need a delta to work out how far to travel etc.
        double delta = this.getElapsed(this.lastUpdate);

        //TODO: Update the model.

        this.lastUpdate = GameUtilities.getTime();
    }



    /**
     * Update the GUI based on the view and locations of objects.
     * Possibly make this asymetrical (fire and forget)?
     * Thread strategy?
     */
    private void render()
    {        
        this.sleep(4);
    }

    public final void save()
    {
        GameSaver saver = new GameSaver(this.gameState);
        saver.save();        
    }

    public final void exit()
    {
        System.out.println("Exiting");
        this.sleep(5);
        System.out.println("-----=-----=-----=-----=-----=-----=-----");
        System.out.println("Total frames: " + this.tickCount);
        System.out.println("Total time: " + Math.round(GameUtilities.getTime() - this.startTime)/1000 + "s");
        System.out.println("Average FPS: " + Math.round(this.tickCount / ((GameUtilities.getTime() - this.startTime)/1000)) );
        
        this.running = false;
        this.save();
        //GameSaver.close();
        //exit view
        System.exit(0);
    }
}