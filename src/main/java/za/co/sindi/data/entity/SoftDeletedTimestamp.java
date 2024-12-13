/**
 * 
 */
package za.co.sindi.data.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author Buhake Sindi
 * @since 29 October 2021
 *
 */
public interface SoftDeletedTimestamp extends LastModifiedTimestamp, SoftDeleted {
	
	default LocalDateTime getDeletedOnAsLocalDateTime() {
		return LocalDateTime.ofInstant(getDeletedOn(), ZoneId.systemDefault());
	}
	
	public Instant getDeletedOn();
	
	public void setDeletedOn(final Instant deletedOn);
	
	default void setDeletedOn(final LocalDateTime deletedOnDateTime) {
		setDeletedOn(deletedOnDateTime, ZoneOffset.UTC);
	}
	
	default void setDeletedOn(final LocalDateTime deletedOnDateTime, final ZoneOffset zoneOffset) {
		setDeletedOn(deletedOnDateTime.toInstant(zoneOffset));
	}
}
