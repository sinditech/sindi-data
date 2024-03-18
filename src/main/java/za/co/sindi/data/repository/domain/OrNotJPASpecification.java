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
public class OrNotJPASpecification<T> extends CompositeJPASpecification<T> {

	private JPASpecification<T> left;
	private JPASpecification<T> right;
	
	/**
	 * @param left
	 * @param right
	 */
	public OrNotJPASpecification(JPASpecification<T> left, JPASpecification<T> right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		// TODO Auto-generated method stub
		return left.isSatisfiedBy(t) || right.not().isSatisfiedBy(t);
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		return criteriaBuilder.or(left.toPredicate(root, query, criteriaBuilder), criteriaBuilder.not(right.toPredicate(root, query, criteriaBuilder)));
	}
}
