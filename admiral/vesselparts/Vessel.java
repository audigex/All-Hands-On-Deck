package admiral.vesselparts;

import admiral.Faction;
import admiral.vesselcontrol.Role;
import admiral.worldplaces.Harbour;
import admiral.vesselcontrol.Strategy;
import admiral.vesselcontrol.PropulsionMethod;
import java.util.ArrayList;

/**
 *
 * @author jon
 */
public abstract class Vessel {
    /**
     * Full name of the vessel
     */
    private String name = "Unknown Vessel";

    /**
     * The faction the vessel belongs to
     * Countries/independent (pirate/nonaligned merchant)
     */
    private Faction faction;

    /**
     * Provides an API to move the vessel
     */
    private PropulsionMethod propulsionMethod;

    /**
     * The type of vessel 
     * ie man'o'war/merchant
     * Needed? Part of role?
     */
    //private Type type;

    /**
     * The role currently being undertaken
     * ie pirate/privateer/merchant/convoy merchant/convoy escort/independent/cruise/patrol/squadron/fleet
     */
    private Role role;
    
    /**
     * Route followed? General direction? Maybe change for a DesiredRoute
     */
    private /*Travel*/Strategy overallStrategy;
    /**
     * What we're trying to do at the moment (ie basic heading)
     * Could be combined with the travel strategy/route by specifying a current leg.
     */
    private /*Movement*/Strategy localStrategy;
    /**
     * What are we trying to do right now? Overall concern if enemies/allies are nearby - form a squadron?
     * Based on the above? Is this a runtime choice rather than a chosen strategy?
     * ie run, hit and run, weakest first, fastest first, closest match, strongest, any enemy, fleet battle?
     */
    private /*Battle*/Strategy tactic;

    /**
     * Where this ship belongs (info purposes) and randomise starting ports based on where ships in the world are from
     */
    private Harbour homePort;
    /**
     * Where the current route's start point was (part of an overarching Route?)
     */
    private Harbour sourcePort;
    /**
     * Where we're going (part of an overarching Route?)
     */
    private Harbour destinationPort;

    /**
     * Length of the vessel in meters (Yes, I know meters is spelt wrong, but the spell checker was doing my head in)
     */
    private int length = 1;
    /**
     * Width of the vessel in meters (Yes, I know meters is spelt wrong, but the spell checker was doing my head in)
     */
    private int width = 1;

    /**
     * Whether the vessel is afloat
     * Assume it's not been sunk yet to start with
     */
    private boolean afloat = true;

    /**
     * Whether the vessel is on fire
     * Assume it's not to start with
     */
    private boolean onFire = false;

    /**
     * Whether the vessel is able to be sunk/set on fire
     * True to start with, but allows bosses/cheat mode
     */
    private boolean destructible = true;

    /**
     * The number of crewmembers the vessel has in normal operational usage (maximum)
     */
    private int maxCrewComplement = 1;
    /**
     * The current number of crew members the vessel has (after casualties)
     */
    private int currentCrewComplement = 1;

    /**
     * The number of decks the chip has
     * TODO: Decide if it's more useful to calculate this on creation (less method calls) or on the fly (less memory)
     */
    private int numberOfDecks = 1;

    /**
     * A list of the decks on the ship.
     */
    private ArrayList<Deck> decks = new ArrayList<Deck>();
    private ArrayList<Mast> masts = new ArrayList<Mast>();
    private ArrayList<Oar> oars = new ArrayList<Oar>();

    /**
     * Initializes a new vessel
     * @param newName - Name of the vessel (User visible, not a reference)
     * @param newLength - The length of the vessel in meters
     * @param newWidth - The width of the vessel in meters
     */
    public Vessel(String newName, int newLength, int newWidth)
    {        
        this.name = newName;
        this.length = newLength;
        this.width = newWidth;
    }

    public void update()
    {
        //Decide on priority strategy (ie enemies nearby)
        //If current strategy is priority
            //Continue
        //else
            //Change priority strategy           
            //Run priority strategy
    }

    public String getName()
    {
        return this.name;
    }

    public int getLength()
    {
        return this.length;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getCurrentCrewComplement()
    {
        return this.currentCrewComplement;
    }

    public int getMaxCrewComplement()
    {
        return this.maxCrewComplement;
    }

    public int getNumberOfDecks()
    {
        return this.numberOfDecks;
    }

    public ArrayList<Deck> getDecks()
    {
        return this.decks;
    }

    public boolean isAfloat()
    {
        return (!this.isDestructible() || this.afloat);
    }
    public boolean isSunk()
    {
        return !this.isAfloat();
    }

    public boolean isOnFire()
    {
        //If it's indestructible, assume it can't catch fire...
        return (this.isDestructible() && this.onFire);
    }

    public boolean isDestructible()
    {
        return this.destructible;
    }

    public void sink()
    {
        this.afloat = false;
    }

    public void setOnFire()
    {
        this.onFire = true;
    }

    public void extinguish()
    {
        this.onFire = false;
    }
}
