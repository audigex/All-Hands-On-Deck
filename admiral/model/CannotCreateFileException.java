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
public class CannotCreateFileException extends AdmiralException
{

    /**
     * Creates a new instance of <code>CannotCreateFileException</code> without detail message.
     */
    public CannotCreateFileException() {
    }


    /**
     * Constructs an instance of <code>CannotCreateFileException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CannotCreateFileException(String msg) {
        super(msg);
    }
}
