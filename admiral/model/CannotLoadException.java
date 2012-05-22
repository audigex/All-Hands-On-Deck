/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admiral.model;

import admiral.AdmiralException;

/**
 *
 * @author jon
 */
public class CannotLoadException extends AdmiralException
{

    /**
     * Creates a new instance of <code>CannotLoadException</code> without detail message.
     */
    public CannotLoadException() {
    }


    /**
     * Constructs an instance of <code>CannotLoadException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CannotLoadException(String msg) {
        super(msg);
    }
}
