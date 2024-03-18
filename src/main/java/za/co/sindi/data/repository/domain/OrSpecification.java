/**
 * 
 */
package za.co.sindi.data.repository.domain;

/**
 * @author Buhake Sindi
 * @since 02 October 2023
 */
public class OrSpecification<T, S extends Specification<T, S>> extends CompositeSpecification<T, S> {

	private S left;
	private S right;
	
	/**
	 * @param left
	 * @param right
	 */
	public OrSpecification(S left, S right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		// TODO Auto-generated method stub
		return left.isSatisfiedBy(t) || right.isSatisfiedBy(t);
	}
}
