/**
 * 
 */
package za.co.sindi.data.repository;

import java.util.Optional;
import java.util.stream.Stream;

import za.co.sindi.data.repository.domain.Specification;

/**
 * @author Buhake Sindi
 * @since 03 October 2023
 */
public interface SpecificationRepository<E, S extends Specification<E, S>> extends DataRepository<E> {

	public long count(S specification);
	public boolean exists(S specification);
	public Optional<E> find(S specification);
	public Stream<E> findAll(S specification);
}
