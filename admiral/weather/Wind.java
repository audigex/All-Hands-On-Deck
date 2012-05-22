/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admiral.weather;

import javax.swing.ImageIcon;

/**
 *
 * @author jon
 */
public enum Wind
{

    DOLDRUM
    {
        ImageIcon icon = new ImageIcon("src/images/blue.gif");
        public ImageIcon getIcon() { return this.icon; }
        public String getName() { return "Doldrums"; }
        public String getDescription() { return "No wind whatsoever"; }
        public String getStrentheningAdvice() { return "Not so much as a whisper, sir, but it looks to be improving soon."; }
        public String getStableAdvice() { return "We're not going anywhere unless we get out and pull, sir, there's no wind."; }
        public String getDroppingAdvice() { return "We may as well be paddling, sir, for all the good the wind is doing us."; }
    },
    CALM
    {
        ImageIcon icon = new ImageIcon("src/images/blue.gif");
        public ImageIcon getIcon() { return this.icon; }
        public String getName() { return "Calm"; }
        public String getDescription() { return "The merest of wafts."; }
        public String getStrentheningAdvice() { return "The wind's picking up, sir."; }
        public String getStableAdvice() { return "Clap on all sail, sir, we need every stitch of canvas."; }
        public String getDroppingAdvice() { return "We may have to whistle for a wind soon, sir, the breeze is dying."; }
    },
    BREEZE
    {
        ImageIcon icon = new ImageIcon("src/images/green.gif");
        public ImageIcon getIcon() { return this.icon; }
        public String getName() { return "Breeze"; }
        public String getDescription() { return "Light wind."; }
        public String getStrentheningAdvice() { return "It might be time to bring in the heavy sails, sir, the wind is picking up"; }
        public String getStableAdvice() { return "We can move, sir, but I'll not vouch for how fast"; }
        public String getDroppingAdvice() { return "Set all canvas, sir, we should make the most of this wind before it's gone"; }
    },
    FAIR
    {
        ImageIcon icon = new ImageIcon("src/images/green.gif");
        public ImageIcon getIcon() { return this.icon; }
        public String getName() { return "Fair"; }
        public String getDescription() { return "Normal levels of wind."; }
        public String getStrentheningAdvice() { return ""; }
        public String getStableAdvice() { return "A fair wind, sir, every sailor's dream."; }
        public String getDroppingAdvice() { return ""; }
    },
    GALE
    {
        ImageIcon icon = new ImageIcon("src/images/yellow.gif");
        public ImageIcon getIcon() { return this.icon; }
        public String getName() { return "Gale"; }
        public String getDescription() { return "A strong wind."; }
        public String getStrentheningAdvice() { return "It's getting stormy, sir, time to think about reducing sail."; }
        public String getStableAdvice() { return "A nice strong wind, sir."; }
        public String getDroppingAdvice() { return "The wind is dropping, sir."; }
    },
    STORM
    {
        ImageIcon icon = new ImageIcon("src/images/yellow.gif");
        public ImageIcon getIcon() { return this.icon; }
        public String getName() { return "Storm"; }
        public String getDescription() { return "Very strong winds, requiring caution."; }
        public String getStrentheningAdvice() { return "Sir. there's a bit of a blow on, may I suggest reducing sail a little?"; }
        public String getStableAdvice() { return "The wind's strong, sir, be careful."; }
        public String getDroppingAdvice() { return "The storm looks to be ending, sir"; }
    },
    HURRICANE
    {
        ImageIcon icon = new ImageIcon("src/images/red.gif");
        public ImageIcon getIcon() { return this.icon; }
        public String getName() { return "Hurricane"; }
        public String getDescription() { return "The strongest winds, able to damage of even sink a vessel."; }
        public String getStrentheningAdvice() { return "Batten down the hatches and reduce sail, sir, this is going to be a rough one."; }
        public String getStableAdvice() { return "Hang on, sir, it's got to end sometime."; }
        public String getDroppingAdvice() { return "The wind is starting to drop, sir, we might make it yet."; }
    };

    //private ImageIcon icon;

    //public abstract ImageIcon getIcon() { return icon; }
    public abstract ImageIcon getIcon();

    public abstract String getName();
    public abstract String getDescription();
    public abstract String getStrentheningAdvice();
    public abstract String getStableAdvice();
    public abstract String getDroppingAdvice();

    /*private static ImageIcon YELLOWICON = new ImageIcon("src/images/yellow.gif");
    private static ImageIcon REDICON = new ImageIcon("src/images/red.gif");
    private static ImageIcon BLUEICON = new ImageIcon("src/images/blue.gif");
    private static ImageIcon GREENICON = new ImageIcon("src/images/green.gif");*/
}