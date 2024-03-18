/**
 * 
 */
package za.co.sindi.data.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Buhake Sindi
 * @since 28 October 2021
 *
 */
public abstract class IdentifiableEntity<PK extends Comparable<PK> & Serializable> implements Comparable<IdentifiableEntity<PK>>, Identifiable<PK>, Entity {

	@Override
	public int compareTo(IdentifiableEntity<PK> o) {
		// TODO Auto-generated method stub
		return getId().compareTo(o.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		IdentifiableEntity<PK> other = (IdentifiableEntity<PK>) obj;
		return Objects.equals(getId(), other.getId());
	}
}
