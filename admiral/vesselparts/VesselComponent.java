package admiral.vesselparts;

/**
 *
 * @author jon
 */
public abstract class VesselComponent
{
    //TODO: Make upgradeable and destructible into interfaces/subclasses?
    private boolean destructible = true;

    private double health = 100.0;

    public void causeDamage(double damagePercentage) throws IndestructibleException
    {
        if(this.destructible)
        {
            this.health -= damagePercentage;
            if(this.health < 0.0)
            {
                this.health = 0.0;                
            }
        }
        else
        {
            throw new IndestructibleException();
        }
    }

    public void destroy() throws IndestructibleException
    {
        this.causeDamage(100.0);
    }
}
