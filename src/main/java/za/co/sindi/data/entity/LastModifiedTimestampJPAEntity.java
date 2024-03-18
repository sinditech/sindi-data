/**
 * 
 */
package za.co.sindi.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;

/**
 * @author Buhake Sindi
 * @since 09 November 2023
 */
@MappedSuperclass
public abstract class LastModifiedTimestampJPAEntity<PK extends Comparable<PK> & Serializable> extends CreatedTimestampJPAEntity<PK> implements LastModifiedTimestamp {

	@Transient
	private boolean setLastModifiedTimestampExplicitly;

	@PreUpdate
	protected void onPreUpdate() {
		if (setLastModifiedTimestampExplicitly && getLastModifiedOn() == null) {
			setLastModifiedOn(LocalDateTime.now());
		}
	}

	public void setLastModifiedTimestampExplicitly() {
		this.setLastModifiedTimestampExplicitly = true;
	}
}
