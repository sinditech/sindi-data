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
public interface LastModifiedTimestamp extends CreatedTimestamp {
	
	default LocalDateTime getLastModifiedOnAsLocalDateTime() {
		return Dates.toLocalDateTime(getLastModifiedOn());
	}
	
//	default LocalDateTime getLastModifiedOnAsLocalDateTime(final ZoneOffset zoneOffset) {
//		Instant instant = getLastModifiedOn().toInstant();
//		return instant == null ? null : LocalDateTime.ofInstant(instant, zoneOffset);
//	}
	
	public Date getLastModifiedOn();
	
	public void setLastModifiedOn(final Date lastModifiedOn);
	
	default void setLastModifiedOn(final LocalDateTime lastModifiedOnDateTime) {
		setLastModifiedOn(Dates.toDate(lastModifiedOnDateTime));
	}
}
