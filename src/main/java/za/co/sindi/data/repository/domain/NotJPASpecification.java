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
 */
public class NotJPASpecification<T> extends CompositeJPASpecification<T> {

	private JPASpecification<T> specification;
	
	/**
	 * @param specification
	 */
	public NotJPASpecification(JPASpecification<T> specification) {
		super();
		this.specification = specification;
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		// TODO Auto-generated method stub
		return !specification.isSatisfiedBy(t);
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		return criteriaBuilder.not(specification.toPredicate(root, query, criteriaBuilder));
	}
}
