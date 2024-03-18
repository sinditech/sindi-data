/**
 * 
 */
package za.co.sindi.data.entity;

/**
 * @author Buhake Sindi
 * @since 14 October 2023
 *
 */
public interface LastModifiedAuditable<U> extends CreatedAuditable<U> {
	
	/**
	 * @return the lastModifiedBy
	 */
	public U getLastModifiedBy();
	
	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public void setLastModifiedBy(U lastModifiedBy);
}
