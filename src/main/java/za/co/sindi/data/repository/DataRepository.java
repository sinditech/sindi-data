/**
 * 
 */
package za.co.sindi.data.repository;

import java.util.stream.Stream;

/**
 * @author Buhake Sindi
 * @since 04 November 2021
 *
 */
public interface DataRepository<E> {
	
	/**
     * Returns the number of entities available.
     *
     * @return the number of entities.
     */
    long count();
    
    /**
     * Deletes a given entity. Deletion is performed by matching the Id, and if the entity is
     * versioned (for example, with {@code jakarta.persistence.Version}), then also the version.
     * Other properties of the entity do not need to match.
     *
     * @param entity must not be {@literal null}.
     * @throws NullPointerException when the entity is null
     */
    void delete(E entity);
    
    /**
     * Deletes all entities managed by the repository.
     */
    void deleteAll();
    
    /**
     * Deletes the given entities. Deletion of each entity is performed by matching the Id, and if the entity is
     * versioned (for example, with {@code jakarta.persistence.Version}), then also the version.
     * Other properties of the entity do not need to match.
     *
     * @param entities must not be {@literal null}. Must not contain {@literal null} elements.
     * @throws NullPointerException when either the iterable is null or contains null elements
     */
    void deleteAll(Iterable<? extends E> entities);
    
    /**
     * Returns all instances of the type.
     *
     * @return all entities; will never be {@literal null}.
     */
    Stream<E> findAll();
    
    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity the entity to be saved
     * @param <S> type of entity to save
     * @return the saved entity; will never be {@literal null}.
     * @throws NullPointerException when the entity is null
     */
    <S extends E> S save(S entity);
    
    /**
     * Saves all given entities.
     *
     * @param entities an iterable of entities
     * @param <S> type of entity to save
     * @return the saved entities; will never be {@literal null}.
     * @throws NullPointerException if either the iterable is null or any element is null
     */
    <S extends E> Iterable<S> saveAll(Iterable<S> entities);
    
    
    /**
     * <p>Modifies an entity that already exists in the database.</p>
     *
     * @param entity the entity to update. Must not be {@code null}.
     * @return true if a matching entity was found in the database to update, otherwise false.
     * @throws NullPointerException if the entity is null.
     */
    public boolean update(final E entity);
    
    /**
     * <p>Modifies entities that already exist in the database.</p>
     *
     * @param entities entities to update.
     * @return the number of matching entities that were found in the database to update.
     * @throws NullPointerException if either the iterable is null or any element is null.
     */
	public int updateAll(Iterable<E> entities);

}
