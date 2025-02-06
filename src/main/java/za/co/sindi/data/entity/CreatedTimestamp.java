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
public interface CreatedTimestamp {
	
	public Instant getCreatedOn();
	
	public void setCreatedOn(final Instant createdOn);
}
