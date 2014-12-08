package admiral.model;

import admiral.weather.Weather;
import admiral.vesselparts.Vessel;
import admiral.worldplaces.Harbour;
import admiral.worldplaces.Region;
import admiral.worldplaces.WorldMap;
import java.util.ArrayList;

/**
 *
 * @author jon
 * TODO: Make this use more of an interface, that way I can switch between eg database, online, and file based models more easily
 *       Also makes it easier to switch format - eg xml to txt or database - without having to re-write anything
 */
public class GameState extends Model
{
    private static GameState INSTANCE;
    private static double LAST_SAVE;

    private ArrayList<Vessel> vessels;
    private ArrayList<Region> regions;
    private ArrayList<Harbour> harbours;
    private Weather weather;
    private WorldMap map;

    /**
     * Create a new game
     */
    private GameState()
    {
        //TODO: Consider multiple save files
        //TODO: Populate ArrayLists
        //TODO: Work out how to only save minimal things - region information not actual regions
        vessels = new ArrayList<Vessel>();
        regions = new ArrayList<Region>();
        harbours = new ArrayList<Harbour>();
        weather = new Weather();
        map = new WorldMap();
    }   

    /**
     * Returns the current game information. Only one GameState instance may be used
     * @return the latest save, or a new game if no saves are available
     */
    public static GameState getInstance()
    {   
        if(GameState.INSTANCE == null)
        {            
            try
            {
                //TODO: Change to loadLast() or autoLoad() or chooseLoad() depending on implementation
                //TODO: This currently uses the auto-save location... probably better to use an option to choose what to load                
                GameLoader loader = new GameLoader();                
                GameState.INSTANCE = loader.load();                
            }
            catch(NoAutoSaveFileException e)
            {                
                GameState.INSTANCE = new GameState();
            }
            catch (CannotLoadException e)
            {               
                GameState.INSTANCE = new GameState();
            }            
        }
        
        return GameState.INSTANCE;
    }  

    public void addVessel(Vessel v)
    {
        this.vessels.add(v);
    }
    public void addVesselList(ArrayList<Vessel> vlist)
    {        
        this.vessels.addAll(vlist);
    }
    public void replaceVesselList(ArrayList<Vessel> vlist)
    {
        this.vessels = vlist;
    }
    public void removeVessel(Vessel v)
    {
        this.vessels.remove(v);
    }
    public void removeVesselList(ArrayList<Vessel> vlist)
    {
        for (Vessel v : vlist)
        {
            this.vessels.remove(v);
        }       
    }
    public ArrayList<Vessel> getVessels()
    {
        return this.vessels;
    }    

    //TODO: Finish GameState get/set methods
}
