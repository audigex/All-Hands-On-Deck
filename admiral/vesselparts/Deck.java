/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admiral.vesselparts;

import java.util.ArrayList;

/**
 *
 * @author jon
 */
public abstract class Deck extends VesselComponent
{

    /**
     * A list of the guns on the ship - possibly better to make it an array later?
     * Or pass in a vector and convert to an array along with the number of guns on each deck in order to sort
     * Alternatively: Better to keep track of the gun separation in individual ship classes
     */
    public ArrayList<Gun> guns;

}
