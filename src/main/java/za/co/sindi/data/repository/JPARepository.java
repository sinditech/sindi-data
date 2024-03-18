/**
 * 
 */
package za.co.sindi.data.repository;

import java.io.Serializable;
import java.util.Optional;

import za.co.sindi.data.entity.JPAEntity;

/**
 * @author Buhake Sindi
 * @since 22 October 2023
 */
public interface JPARepository<E extends JPAEntity<ID>, ID extends Comparable<ID> & Serializable> extends PageableRepository<E, ID> {

	public Optional<E> findReferenceById(ID id);
}
