package admiral.view;

import admiral.controller.Controller;
import admiral.model.Model;
import javax.swing.JFrame;

/**
 *
 * @author jon
 */
public class View extends JFrame
{

    private Model model;
    private Controller controller;

    public View(String title)
    {
        super(title);
    }
    public View(String title, Model m, Controller c)
    {
        this(title);
        this.model = m;
        this.controller = c;
    }
   
}