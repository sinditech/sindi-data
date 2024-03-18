/**
 * 
 */
package za.co.sindi.data.repository.domain;

/**
 * @author Buhake Sindi
 * @since 05 October 2023
 */
public abstract class CompositeSpecification<T, S extends Specification<T, S>> implements Specification<T, S> {

	@SuppressWarnings("unchecked")
	@Override
	public S and( S other) {
		// TODO Auto-generated method stub
		return (S) new AndSpecification<T, S>((S) this, other);
	}

	@SuppressWarnings("unchecked")
	@Override
	public S andNot( S other) {
		// TODO Auto-generated method stub
		return (S) new AndNotSpecification<T, S>((S) this, other);
	}

	@SuppressWarnings("unchecked")
	@Override
	public S or( S other) {
		// TODO Auto-generated method stub
		return (S) new OrSpecification<T, S>((S) this, other);
	}

	@SuppressWarnings("unchecked")
	@Override
	public S orNot( S other) {
		// TODO Auto-generated method stub
		return (S) new OrNotSpecification<T, S>((S) this, other);
	}

	@SuppressWarnings("unchecked")
	@Override
	public S not() {
		// TODO Auto-generated method stub
		return (S) new NotSpecification<T, S>((S) this);
	}
}
