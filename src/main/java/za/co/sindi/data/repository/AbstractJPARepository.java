/**
 * 
 */
package za.co.sindi.data.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import za.co.sindi.data.entity.JPAEntity;
import za.co.sindi.data.exception.DataAccessException;

/**
 * @author Buhake Sindi
 * @since 23 August 2022
 *
 */
public abstract class AbstractJPARepository<E extends JPAEntity<ID>, ID extends Comparable<ID> & Serializable> implements JPARepository<E, ID> {

	protected static final String NULL_ENTITYMANAGER = "No EntityManager provided.";
	
	protected Class<E> domainClass;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected AbstractJPARepository() {
		super();
		// TODO Auto-generated constructor stub
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.domainClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}

	/**
	 * @param domainClass
	 */
	protected AbstractJPARepository(Class<E> domainClass) {
		super();
		this.domainClass = domainClass;
	}
	
	@Override
	public Optional<E> findById(ID id) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		return Optional.ofNullable(entityManager.find(domainClass, id));
	}
	
	@Override
	public Optional<E> findReferenceById(ID id) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		try {
			return Optional.of(entityManager.getReference(domainClass, id));
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			return Optional.empty();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public boolean existsById(ID id) {
		// TODO Auto-generated method stub
		try {
			final EntityManager entityManager = getEntityManager();
			
			if (entityManager == null) {
				throw new DataAccessException(NULL_ENTITYMANAGER);
			}
			
			TypedQuery<Boolean> query = getEntityManager().createQuery("SELECT CASE WHEN (COUNT(c) = 1) THEN true ELSE false END FROM " + domainClass.getSimpleName() + " c WHERE c.id = ?1", boolean.class);
			query.setParameter(1, id);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public Stream<E> findAllById(Iterable<ID> ids) {
		// TODO Auto-generated method stub
		try {
			final EntityManager entityManager = getEntityManager();
			
			if (entityManager == null) {
				throw new DataAccessException(NULL_ENTITYMANAGER);
			}
			
			TypedQuery<E> query = getEntityManager().createQuery("SELECT c FROM " + domainClass.getSimpleName() + " c WHERE c.id IN ?1", domainClass);
			query.setParameter(1, ids);
//			query.setParameter(1, ids instanceof List ? (List<ID>) ids : StreamSupport.stream(ids.spliterator(), false).toList());
			return query.getResultStream();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		try {
			E entity = entityManager.getReference(domainClass, id);
			if (entity != null) {
				entityManager.remove(entity);
			}
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public void deleteAllById(Iterable<ID> ids) {
		// TODO Auto-generated method stub
		try {
			final EntityManager entityManager = getEntityManager();
			
			if (entityManager == null) {
				throw new DataAccessException(NULL_ENTITYMANAGER);
			}
			
			Query query = entityManager.createQuery("DELETE FROM " + domainClass.getSimpleName() + " c WHERE c.id IN ?1");
			query.setParameter(1, ids);
//			query.setParameter(1, ids instanceof List ? (List<ID>) ids : StreamSupport.stream(ids.spliterator(), false).toList());
			query.executeUpdate();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		long count = 0;
		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Long> query = builder.createQuery(Long.class);
			query.select(builder.count(query.from(domainClass)));
			count = entityManager.createQuery(query).getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			if (e instanceof NoResultException) {
				count = 0;
			} else {
				throw new DataAccessException(e);
			}
		}
		
		return count;
	}

	@Override
	public void delete(E entity) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		try {
			entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		try {
			final EntityManager entityManager = getEntityManager();
			
			if (entityManager == null) {
				throw new DataAccessException(NULL_ENTITYMANAGER);
			}
			
			Query query = entityManager.createQuery("DELETE FROM " + domainClass.getSimpleName() + " c");
			query.executeUpdate();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public void deleteAll(Iterable<? extends E> entities) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		try {
			entities.forEach(entity -> {
				entityManager.remove(entityManager.merge(entity));
			});
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public Stream<E> findAll() {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		TypedQuery<E> query = entityManager.createQuery("SELECT c FROM " + domainClass.getSimpleName() + " c", domainClass);
		return query.getResultStream();
	}

	@Override
	public Stream<E> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(domainClass);
		Root<E> root = criteriaQuery.from(domainClass);
		criteriaQuery.select(root);
		populateSorts(root, criteriaQuery, criteriaBuilder, pageable);
		
		TypedQuery<E> query = entityManager.createQuery(criteriaQuery);
		populatePage(query, pageable);
		return query.getResultStream();
	}

	@Override
	public <S extends E> S save(S entity) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		if (entity == null) {
			throw new IllegalArgumentException("Cannot insert a null entity.");
		}
		
		try {
			entityManager.persist(entity);
			entityManager.flush();
			entityManager.clear();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
		
		return entity;
	}

	@Override
	public <S extends E> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		if (entities == null) {
			throw new IllegalArgumentException("Cannot insert a null entities.");
		}
		
		try {
			entities.forEach(entityManager::persist);
			entityManager.flush();
			entityManager.clear();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
		
		return entities;
	}

	@Override
	public boolean update(E entity) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		if (entity == null) {
			throw new NullPointerException("Cannot insert a null entity.");
		}
		
//		S mergedEntity;
		
		try {
//			mergedEntity = entityManager.merge(entity);
			entityManager.merge(entity);
			entityManager.flush();
			entityManager.clear();
			return true;
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public int updateAll(Iterable<E> entities) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		if (entities == null) {
			throw new IllegalArgumentException("Cannot insert a null entities.");
		}
		
//		Collection<S> mergedEntities = new ArrayList<>();
		final AtomicInteger total = new AtomicInteger();
		
		try {
			entities.forEach(entity -> {
				if (entityManager.contains(entity)) {
//					mergedEntities.add(entityManager.merge(entity));
					entityManager.merge(entity);
					total.incrementAndGet();
				}
			});
			entityManager.flush();
			entityManager.clear();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
		
//		return Collections.unmodifiableCollection(mergedEntities);
		return total.get();
	}
	
	protected void populateSorts(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder, Pageable pageable) {
		if (pageable.getSorts() != null) {
			for (Sort sort : pageable.getSorts()) {
				if (sort.isAscending()) {
					criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sort.getPropertyName())));
				} else if (sort.isDescending()) {
					criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sort.getPropertyName())));
				}
			}
		}
	}
	
	protected void populatePage(TypedQuery<?> query, Pageable pageable) {
		query.setFirstResult((int)(pageable.getPageNumber() - 1) * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
	}

	protected abstract EntityManager getEntityManager();
}
