/**
 * 
 */
package za.co.sindi.data.repository.domain;

/**
 * @author Buhake Sindi
 * @since 02 October 2023
 */
public abstract class CompositeJPASpecification<T> /* extends CompositeSpecification<T, JPASpecification<T>> */ implements JPASpecification<T> {

	@Override
	public JPASpecification<T> and(JPASpecification<T> other) {
		// TODO Auto-generated method stub
		return new AndJPASpecification<>(this, other);
	}

	@Override
	public JPASpecification<T> andNot(JPASpecification<T> other) {
		// TODO Auto-generated method stub
		return new AndNotJPASpecification<>(this, other);
	}

	@Override
	public JPASpecification<T> or(JPASpecification<T> other) {
		// TODO Auto-generated method stub
		return new OrJPASpecification<>(this, other);
	}

	@Override
	public JPASpecification<T> orNot(JPASpecification<T> other) {
		// TODO Auto-generated method stub
		return new OrNotJPASpecification<>(this, other);
	}

	@Override
	public JPASpecification<T> not() {
		// TODO Auto-generated method stub
		return new NotJPASpecification<>(this);
	}
}
