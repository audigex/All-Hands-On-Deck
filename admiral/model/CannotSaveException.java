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
public class CannotSaveException extends AdmiralException
{

    /**
     * Creates a new instance of <code>CannotSaveException</code> without detail message.
     */
    public CannotSaveException() {
    }


    /**
     * Constructs an instance of <code>CannotSaveException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CannotSaveException(String msg) {
        super(msg);
    }
}
