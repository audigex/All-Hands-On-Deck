/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admiral;

/**
 *
 * @author jon
 */
public class AdmiralException extends Exception
{

    /**
     * Creates a new instance of <code>AdmiralException</code> without detail message.
     */
    public AdmiralException()
    {
        GameUtilities.debug("Exception thrown " + this.getCause());
    }


    /**
     * Constructs an instance of <code>AdmiralException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public AdmiralException(String msg) {
        super(msg);
        GameUtilities.debug(this.getMessage());
    }


}
