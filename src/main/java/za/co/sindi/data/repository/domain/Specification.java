/**
 * 
 */
package za.co.sindi.data.repository.domain;

/**
 * @author Buhake Sindi
 * @since 02 October 2023
 *
 */
public interface Specification<T, S extends Specification<T, S>> {

	public boolean isSatisfiedBy(T t);
	
	public S and(final S other);
	public S andNot(final S other);
	public S or(final S other);
	public S orNot(final S other);
	public S not();
}
