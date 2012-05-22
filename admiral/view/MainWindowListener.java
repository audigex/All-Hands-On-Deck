package admiral.view;

import admiral.GameController;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author jon
 */
public class MainWindowListener implements WindowListener
{
    private GameController controller;
    private View window;
    
    public MainWindowListener(GameController c, View w)
    {
        this.controller = c;
        this.window = w;
        System.out.println("Listener created");
    }
    
    public void windowActivated(WindowEvent e)
    {
        //Invoked when the Window is set to be the active Window.
        //Start rendering the window
    }

    public void windowClosed(WindowEvent e)
    {
        //Invoked when a window has been closed as the result of calling dispose on the window
        System.out.println("WindowListener: closing");
        this.controller.exit();
    }
    public void windowClosing(WindowEvent e)
    {
        //Invoked when the user attempts to close the window from the window's system menu.
        System.out.println("WindowListener: closing");
        this.controller.exit();
    }
    public void windowDeactivated(WindowEvent e)
    {
        //Invoked when a Window is no longer the active Window.
        //Stop rendering temporarily? Depends on the window, I guess
    }
    public void windowDeiconified(WindowEvent e)
    {
        //Invoked when a window is changed from a minimized to a normal state.
        //Start window running again
    }
    public void windowIconified(WindowEvent e)
    {
        //Invoked when a window is changed from a normal to a minimized state.
        //Stop window running to save power
    }
    public void windowOpened(WindowEvent e)
    {
        //Invoked the first time a window is made visible.
        //Start rendering? Run setup?
    }
}