/**
 * 
 */
package za.co.sindi.data.repository;

import java.util.stream.Stream;

/**
 * @author Buhake Sindi
 * @since 28 December 2023
 */
public interface PageableRepository<E, ID> extends CrudRepository<E, ID> {

	public Stream<E> findAll(final Pageable pageable);
}
