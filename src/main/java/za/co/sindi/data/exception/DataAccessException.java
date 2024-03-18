/**
 * 
 */
package za.co.sindi.data.exception;

/**
 * 
 * @author Buhake Sindi
 * @since 10/08/2023
 */
public class DataAccessException extends DataException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269516470827442852L;

	/**
	 * @param message
	 * @param cause
	 */
	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DataAccessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DataAccessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
