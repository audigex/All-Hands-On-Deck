package admiral.dockyard;

import admiral.vesselparts.Gun;

/**
 *
 * @author jon
 */
public class GunFactory
{
    private static GunFactory instance = null;

    private GunFactory()
    {

    }

    public static GunFactory getInstance()
    {
        if(GunFactory.instance == null)
        {
            GunFactory.instance = new GunFactory();
        }
        return GunFactory.instance;
    }

    public Gun create()
    {
        return null;
    }
}
