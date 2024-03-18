/**
 * 
 */
package za.co.sindi.data.repository;

/**
 * @author Buhake Sindi
 * @since 22 October 2023
 */
public class Unsorted extends Sort {

	/**
	 * @param propertyName
	 */
	protected Unsorted(String propertyName) {
		super(propertyName);
	}

	@Override
	public boolean unsorted() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAscending() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDescending() {
		// TODO Auto-generated method stub
		return false;
	}
}
