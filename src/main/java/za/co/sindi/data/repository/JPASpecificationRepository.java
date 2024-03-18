/**
 * 
 */
package za.co.sindi.data.repository;

import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import za.co.sindi.data.entity.JPAEntity;
import za.co.sindi.data.exception.DataAccessException;
import za.co.sindi.data.repository.domain.JPASpecification;

/**
 * @author Buhake Sindi
 * @since 03 October 2023
 */
public abstract class JPASpecificationRepository<E extends JPAEntity<ID>, ID extends Comparable<ID> & Serializable> extends AbstractJPARepository<E, ID> implements SpecificationRepository<E, JPASpecification<E>> {

	@Override
	public long count(JPASpecification<E> specification) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class); //builder.createQuery(persistentClass);
		Root<E> root = query.from(domainClass);
		query.select(builder.count(root))
			 .where(specification.toPredicate(root, query, builder));
		
		return entityManager.createQuery(query).getSingleResult();
	}

	@Override
	public boolean exists(JPASpecification<E> specification) {
		// TODO Auto-generated method stub
		return count(specification) > 0;
	}

	@Override
	public Optional<E> find(JPASpecification<E> specification) {
		// TODO Auto-generated method stub
		try {
			return Optional.of(createQueryBySpecification(specification).getSingleResult());
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return Optional.empty();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	@Override
	public Stream<E> findAll(JPASpecification<E> specification) {
		// TODO Auto-generated method stub
		try {
			return createQueryBySpecification(specification).getResultStream();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}
	
	private TypedQuery<E> createQueryBySpecification(final JPASpecification<E> specification) {
		final EntityManager entityManager = getEntityManager();
		
		if (entityManager == null) {
			throw new DataAccessException(NULL_ENTITYMANAGER);
		}
		
		try {
			CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<E> query = builder.createQuery(domainClass);
			Root<E> root = query.from(domainClass);
			query.where(specification.toPredicate(root, query, builder));
			
			return entityManager.createQuery(query);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}
}
