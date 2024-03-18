/**
 * 
 */
package za.co.sindi.data.entity;

/**
 * @author Buhake Sindi
 * @since 14 October 2023
 *
 */
public interface SoftDeletedAuditable<U> extends LastModifiedAuditable<U>, SoftDeleted {
	
	/**
	 * @return the deletedBy
	 */
	public U getDeletedBy();

	/**
	 * @param deletedBy the deletedBy to set
	 */
	public void setDeletedBy(U deletedBy);
}
