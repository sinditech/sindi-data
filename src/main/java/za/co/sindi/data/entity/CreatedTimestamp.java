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
public interface CreatedTimestamp {
	
	default LocalDateTime getCreatedOnAsLocalDateTime() {
		return LocalDateTime.ofInstant(getCreatedOn(), ZoneId.systemDefault());
	}
	
	public Instant getCreatedOn();
	
	public void setCreatedOn(final Instant createdOn);
	
	default void setCreatedOn(final LocalDateTime createdOnDateTime) {
		setCreatedOn(createdOnDateTime, ZoneOffset.UTC);
	}
	
	default void setCreatedOn(final LocalDateTime createdOnDateTime, final ZoneOffset zoneOffset) {
		setCreatedOn(createdOnDateTime.toInstant(zoneOffset));
	}
}
