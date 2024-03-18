/**
 * 
 */
package za.co.sindi.data.entity;

import java.time.LocalDateTime;
import java.util.Date;

import za.co.sindi.commons.utils.Dates;

/**
 * @author Buhake Sindi
 * @since 29 October 2021
 *
 */
public interface SoftDeletedTimestamp extends LastModifiedTimestamp, SoftDeleted {
	
	default LocalDateTime getDeletedOnAsLocalDateTime() {
		return Dates.toLocalDateTime(getDeletedOn());
	}
	
//	default LocalDateTime getDeletedOnAsLocalDateTime(final ZoneOffset zoneOffset) {
//		Instant instant = getDeletedOn().toInstant();
//		return instant == null ? null : LocalDateTime.ofInstant(instant, zoneOffset);
//	}
	
	public Date getDeletedOn();
	
	public void setDeletedOn(final Date deletedOn);
	
	default void setDeletedOn(final LocalDateTime deletedOnDateTime) {
		setDeletedOn(Dates.toDate(deletedOnDateTime));
	}
}
