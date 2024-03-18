/**
 * 
 */
package za.co.sindi.data.repository.domain;

/**
 * @author Buhake Sindi
 * @since 02 October 2023
 */
public class OrNotSpecification<T, S extends Specification<T, S>> extends CompositeSpecification<T, S> {

	private S left;
	private S right;
	
	/**
	 * @param left
	 * @param right
	 */
	public OrNotSpecification(S left, S right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isSatisfiedBy(T t) {
		// TODO Auto-generated method stub
		return left.isSatisfiedBy(t) || right.not().isSatisfiedBy(t);
	}
}
