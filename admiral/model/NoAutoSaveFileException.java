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
public class NoAutoSaveFileException extends AdmiralException
{

    /**
     * Creates a new instance of <code>NoAutoSaveFileException</code> without detail message.
     */
    public NoAutoSaveFileException() {
    }


    /**
     * Constructs an instance of <code>NoAutoSaveFileException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NoAutoSaveFileException(String msg) {
        super(msg);
    }
}
