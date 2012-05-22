/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admiral.vesselparts;

import admiral.AdmiralException;

/**
 *
 * @author jon
 */
public class IndestructibleException extends AdmiralException
{

    /**
     * Creates a new instance of <code>IndestructibleException</code> without detail message.
     */
    public IndestructibleException() {
    }


    /**
     * Constructs an instance of <code>IndestructibleException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public IndestructibleException(String msg) {
        super(msg);
    }
}
