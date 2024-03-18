/**
 * 
 */
package za.co.sindi.data.repository.domain;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * @author Buhake Sindi
 * @since 02 October 2023
 *
 */
public interface JPASpecification<T> extends Specification<T, JPASpecification<T>> {

	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);
	
//	public JPASpecification<T> and(final JPASpecification<T> other);
//	public JPASpecification<T> andNot(final JPASpecification<T> other);
//	public JPASpecification<T> or(final JPASpecification<T> other);
//	public JPASpecification<T> orNot(final JPASpecification<T> other);
//	public JPASpecification<T> not();
}
