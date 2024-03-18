/**
 * 
 */
package za.co.sindi.data.exception;

/**
 * @author Buhake Sindi
 * @since 19 November 2023
 */
public class EntityExistsException extends DataException {

	/**
	 * @param message
	 * @param cause
	 */
	public EntityExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public EntityExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public EntityExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
