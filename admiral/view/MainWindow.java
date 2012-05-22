package admiral.view;

import admiral.GameController;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jon
 */
public class MainWindow extends View
{        
    public MainWindow()
    {
        super(GameController.NAME);        
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //this.setUndecorated(true);

        this.setVisible(true);
        //this.pack();
    }

}
