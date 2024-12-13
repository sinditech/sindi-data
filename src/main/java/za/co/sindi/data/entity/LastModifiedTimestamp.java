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
public interface LastModifiedTimestamp extends CreatedTimestamp {
	
	default LocalDateTime getLastModifiedOnAsLocalDateTime() {
		return LocalDateTime.ofInstant(getLastModifiedOn(), ZoneId.systemDefault());
	}
	
	public Instant getLastModifiedOn();
	
	public void setLastModifiedOn(final Instant lastModifiedOn);
	
	default void setLastModifiedOn(final LocalDateTime lastModifiedOnDateTime) {
		setLastModifiedOn(lastModifiedOnDateTime, ZoneOffset.UTC);
	}
	
	default void setLastModifiedOn(final LocalDateTime lastModifiedOnDateTime, final ZoneOffset zoneOffset) {
		setLastModifiedOn(lastModifiedOnDateTime.toInstant(zoneOffset));
	}
}
