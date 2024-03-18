/**
 * 
 */
package za.co.sindi.data.exception;

/**
 * 
 * @author Buhake Sindi
 * @since 10/08/2023
 */
public class DataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269516470827442852L;

	/**
	 * @param message
	 * @param cause
	 */
	public DataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
