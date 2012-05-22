package admiral;

import admiral.worldplaces.Region;
import java.util.ArrayList;

/**
 *
 * @author jon
 */
public class Faction
{
    private String name;
    private Region homeland;
    private ArrayList<Region> empire = new ArrayList<Region>();

    public Faction(String n, Region h)
    {
        this.name = n;
        this.homeland = h;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void captureRegion(Region r)
    {
        this.empire.add(r);
    }

}
