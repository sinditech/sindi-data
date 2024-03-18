/**
 * 
 */
package za.co.sindi.data.repository;

/**
 * @author Buhake Sindi
 * @since 22 October 2023
 */
public class SortOrder extends Sort {
	
	private final SortDirection sortDirection; 
	private final boolean ignoreCase;
	
	/**
	 * @param propertyName
	 * @param sortDirection
	 */
	protected SortOrder(String propertyName, SortDirection sortDirection, boolean ignoreCase) {
		super(propertyName);
		if (sortDirection == null) {
			throw new IllegalArgumentException("Sort direction is null.");
		}
		
		this.sortDirection = sortDirection;
		this.ignoreCase = ignoreCase;
	}

	@Override
	public boolean unsorted() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isAscending() {
		return sortDirection.isAscending();
	}
	
	public boolean isDescending() {
		return !sortDirection.isAscending();
	}

	/**
	 * @return the ignoreCase
	 */
	public boolean isIgnoreCase() {
		return ignoreCase;
	}
}
