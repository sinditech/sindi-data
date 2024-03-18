/**
 * 
 */
package za.co.sindi.data.repository;

import java.util.Collections;
import java.util.List;

/**
 * @author Buhake Sindi
 * @since 22 October 2023
 */
public interface Pageable {

	public long getPageNumber();
	
	public int getPageSize();
	
	public List<Sort> getSorts();
	
	static Pageable ofPage(final long pageNumber) {
		return new Pagination(pageNumber, 10, Collections.emptyList());
	}
	
	static Pageable ofSize(final int pageSize) {
		return new Pagination(1, pageSize, Collections.emptyList());
	}
	
	public Pageable sort(final List<Sort> sorts);
	
	public Pageable sort(final Sort... sorts);
}
