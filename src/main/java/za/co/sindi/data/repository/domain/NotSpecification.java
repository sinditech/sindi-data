/**
 * 
 */
package za.co.sindi.data.repository.domain;

/**
 * @author Buhake Sindi
 * @since 02 October 2023
 */
public class NotSpecification<T, S extends Specification<T, S>> extends CompositeSpecification<T, S> {

	private S specification;
	
	/**
	 * @param specification
	 */
	public NotSpecification(S specification) {
		super();
		this.specification = specification;
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		// TODO Auto-generated method stub
		return !specification.isSatisfiedBy(t);
	}
}
