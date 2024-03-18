/**
 * 
 */
package za.co.sindi.data.entity;

import java.io.Serializable;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import za.co.sindi.commons.utils.Classes;
import za.co.sindi.commons.utils.Defaults;
import za.co.sindi.data.listener.AuditableEntityListener;

/**
 * @author Buhake Sindi
 * @since 14 October 2023
 */
@MappedSuperclass
@EntityListeners(AuditableEntityListener.class)
public abstract class JPAEntity<PK extends Comparable<PK> & Serializable> extends IdentifiableEntity<PK> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8463141366693852467L;
	
	@Transient
	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		PK id = getId();
		if (id == null) return true;
		
		Class<?> idClass = id.getClass();
		if (!idClass.isPrimitive()) {
			idClass = Classes.getPrimitiveTypeFor(idClass);
		}
		
		if (idClass != null) {
			return id.equals(Defaults.getDefaultValue(idClass));
		}
		
		if (id instanceof String s) return s.isEmpty();
		
		//It is not null
		return false;
	}
}
