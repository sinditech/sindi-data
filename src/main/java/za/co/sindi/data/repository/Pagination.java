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
public class Pagination implements Pageable {
	
	private final long pageNumber;
	private final int pageSize;
	private List<Sort> sorts;
	
	/**
	 * @param pageNumber
	 * @param pageSize
	 * @param sorts
	 */
	protected Pagination(long pageNumber, int pageSize, List<Sort> sorts) {
		super();
		if (pageNumber < 1) {
            throw new IllegalArgumentException("pageNumber: " + pageNumber);
        } 
		
		if (pageSize < 1) {
            throw new IllegalArgumentException("pageSize: " + pageSize);
        }
		
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.sorts = sorts;
	}

	@Override
	public long getPageNumber() {
		// TODO Auto-generated method stub
		return pageNumber;
	}

	@Override
	public int getPageSize() {
		// TODO Auto-generated method stub
		return pageSize;
	}

	@Override
	public List<Sort> getSorts() {
		// TODO Auto-generated method stub
		return sorts;
	}

	@Override
	public Pagination sort(List<Sort> sorts) {
		// TODO Auto-generated method stub
		return new Pagination(pageNumber, pageSize, sorts == null ? Collections.emptyList() : sorts);
	}

	@Override
	public Pagination sort(Sort... sorts) {
		// TODO Auto-generated method stub
		return new Pagination(pageNumber, pageSize, sorts == null ? Collections.emptyList() : List.of(sorts));
	}
}
