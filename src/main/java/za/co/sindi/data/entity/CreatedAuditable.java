/**
 * 
 */
package za.co.sindi.data.entity;

/**
 * @author Buhake Sindi
 * @since 14 October 2023
 */
public interface CreatedAuditable<U> {

	/**
	 * @return the createdBy
	 */
	public U getCreatedBy();

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(U createdBy);
}
