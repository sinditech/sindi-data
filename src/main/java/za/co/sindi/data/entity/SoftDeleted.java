/**
 * 
 */
package za.co.sindi.data.entity;

/**
 * @author Buhake Sindi
 * @since 04 November 2021
 *
 */
public interface SoftDeleted {
	
	public boolean isDeleted();
	
	public void setDeleted(final boolean deleted);
}
