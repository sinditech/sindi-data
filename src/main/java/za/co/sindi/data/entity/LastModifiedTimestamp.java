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
public interface LastModifiedTimestamp extends CreatedTimestamp {
	
	public Instant getLastModifiedOn();
	
	public void setLastModifiedOn(final Instant lastModifiedOn);
}
