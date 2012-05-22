package admiral.vesselparts;

import admiral.GameUtilities;

/**
 * Split into gun/carronade/chaser (long 9)?
 * Enums don't seem to be the way forward here
 * @author jon
 */
public abstract class Gun extends VesselComponent
{

    /**
     * The gun type (carronade/chaser/normal broadside)
     */
    private GunType type;
    /**
     * The size of projectile the gun fires in lbs (gun strength)
     */
    private Calibre calibre;
    /**
     * The style of weapon (linstock/flintlock)
     */
    private FiringStyle firingStyle;
    /**
     * Whether the gun has been knocked off it's carriage
     */
    private boolean dismounted = false;    
    /**
     * Number of times the cannon has been fired
     */
    private int fireCount;
    /**
     * Loading percentage (0 = just fired; 100 = loaded)
     */
    private int percentLoaded = 0;
    /**
     * The time the gun was last fired
     */
    private double lastFired;    

    /**
     * Types of gun
     */
    public enum GunType { CARRONADE, CHASE, BROADSIDE }
    /**
     * Type of firing, relates to firing speed and number of misfires
     */
    public enum FiringStyle { LINSTOCK, FLINTLOCK }
    /**
     * Weight of shot in lbs
     */
    public enum Calibre { TWO, FOUR, SIX, NINE, TWELVE, EIGHTEEN, TWENTY_FOUR, THIRTY_TWO, FORTY_EIGHT, SIXTY_FOUR }

    public Gun(Calibre newCalibre, FiringStyle newStyle, GunType newType)
    {
        this.calibre = newCalibre;     
        this.type = newType;
    }

    public void dismount()
    {
        this.dismounted = true;
    }    

    public void fire()
    {
        this.fireCount++;
        this.percentLoaded = 0;
        this.lastFired = GameUtilities.getTime();
    }

}