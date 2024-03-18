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
public interface CreatedTimestamp {
	
	default LocalDateTime getCreatedOnAsLocalDateTime() {
		return Dates.toLocalDateTime(getCreatedOn());
	}
	
//	default LocalDateTime getCreatedOnAsLocalDateTime(final ZoneOffset zoneOffset) {
//		Instant instant = getCreatedOn().toInstant();
//		return instant == null ? null : LocalDateTime.ofInstant(instant, zoneOffset);
//	}
	
	public Date getCreatedOn();
	
	public void setCreatedOn(final Date createdOn);
	
	default void setCreatedOn(final LocalDateTime createdOnDateTime) {
		setCreatedOn(Dates.toDate(createdOnDateTime));
	}
}
