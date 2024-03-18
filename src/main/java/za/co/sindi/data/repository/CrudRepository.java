/**
 * 
 */
package za.co.sindi.data.repository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Buhake Sindi
 * @since 04 November 2021
 *
 */
public interface CrudRepository<E, ID> extends DataRepository<E>/*, CrudRepository<E, ID> */ {

	/**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     * @throws NullPointerException when the id is null
     */
    Optional<E> findById(ID id);

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id must not be {@literal null}.
     * @return {@literal true} if an entity with the given id exists, {@literal false} otherwise.
     * @throws NullPointerException when the ID is null
     */
    boolean existsById(ID id);
    
    /**
     * Returns all instances of the type {@code T} with the given IDs.
     * <p>
     * If some or all ids are not found, no entities are returned for these IDs.
     * <p>
     * Note that the order of elements in the result is not guaranteed.
     *
     * @param ids must not be {@literal null} nor contain any {@literal null} values.
     * @return guaranteed to be not {@literal null}. The size can be equal or less than the number of given
     * {@literal ids}.
     * @throws NullPointerException in case the given {@link Iterable ids} or one of its items is {@literal null}.
     */
    Stream<E> findAllById(Iterable<ID> ids);
    
    /**
     * Deletes the entity with the given id.
     * <p>
     * If the entity is not found in the persistence store it is silently ignored.
     *
     * @param id must not be {@literal null}.
     * @throws NullPointerException when the id is null
     */
    void deleteById(ID id);
    
    /**
     * Deletes all instances of the type {@code T} with the given IDs.
     * <p>
     * Entities that aren't found in the persistence store are silently ignored.
     *
     * @param ids must not be {@literal null}. Must not contain {@literal null} elements.
     * @throws NullPointerException when either the iterable is null or contains null elements
     */
    void deleteAllById(Iterable<ID> ids);
}
