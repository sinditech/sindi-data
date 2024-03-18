/**
 * 
 */
package za.co.sindi.data.repository;

import za.co.sindi.commons.utils.Strings;

/**
 * @author Buhake Sindi
 * @since 22 October 2023
 */
public abstract class Sort {

	private final String propertyName;

	/**
	 * @param propertyName
	 */
	protected Sort(String propertyName) {
		super();
		if (Strings.isNullOrEmpty(propertyName)) {
			throw new IllegalArgumentException("propertyName is null or empty");
		}
		
		this.propertyName = propertyName;
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	public static Sort by(final String propertyName) {
		return new Unsorted(propertyName);
	}
	
	public Sort ascending() {
		return ascending(true);
	}
	
	public Sort ascending(final boolean ignoreCase) {
		return new SortOrder(propertyName, SortDirection.ASCENDING, ignoreCase);
	}
	
	public Sort descending() {
		return descending(true);
	}
	
	public Sort descending(final boolean ignoreCase) {
		return new SortOrder(propertyName, SortDirection.DESCENDING, ignoreCase);
	}
	
	public abstract boolean unsorted();
	
	public abstract boolean isAscending();
	
	public abstract boolean isDescending();

	public static enum SortDirection {
		ASCENDING(true)
		,DESCENDING(false)
		;
		private final boolean ascending;

		/**
		 * @param ascending
		 */
		private SortDirection(boolean ascending) {
			this.ascending = ascending;
		}

		/**
		 * @return the ascending
		 */
		public boolean isAscending() {
			return ascending;
		}
	}
}
