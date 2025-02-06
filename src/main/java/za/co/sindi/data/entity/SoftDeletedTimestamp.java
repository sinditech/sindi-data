/**
 * 
 */
package za.co.sindi.data.entity;

import java.time.Instant;

/**
 * @author Buhake Sindi
 * @since 29 October 2021
 *
 */
public interface SoftDeletedTimestamp extends LastModifiedTimestamp, SoftDeleted {
	
	public Instant getDeletedOn();
	
	public void setDeletedOn(final Instant deletedOn);
}
