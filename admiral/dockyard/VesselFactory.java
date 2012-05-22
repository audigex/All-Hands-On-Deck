package admiral.dockyard;

import admiral.vesselparts.Vessel;

/**
 *
 * @author jon
 */
public class VesselFactory {

    private static VesselFactory instance = null;

    private VesselFactory()
    {
        
    }

    public static VesselFactory getInstance()
    {
        if(VesselFactory.instance == null)
        {
            VesselFactory.instance = new VesselFactory();
        }
        return VesselFactory.instance;
    }

    public Vessel create()
    {
        return null;
    }

}
