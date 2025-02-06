/**
 * 
 */
package za.co.sindi.data.entity;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;

/**
 * @author Buhake Sindi
 * @since 09 November 2023
 */
@MappedSuperclass
public abstract class CreatedTimestampJPAEntity<PK extends Comparable<PK> & Serializable> extends JPAEntity<PK> implements CreatedTimestamp {

	@Transient
	private boolean setCreatedOnTimestampExplicitly;

	@PrePersist
	protected void onPrePersist() {
		if (setCreatedOnTimestampExplicitly && getCreatedOn() == null) {
			setCreatedOn(Instant.now());
		}
	}

	public void setCreatedOnTimestampExplicitly() {
		this.setCreatedOnTimestampExplicitly = true;
	}
}
