/**
 * 
 */
package za.co.sindi.data.entity;

import java.io.Serializable;

/**
 * @author Buhake Sindi
 * @since 28 October 2021
 *
 */
public interface Identifiable<PK extends Comparable<PK> & Serializable> {

	/**
	 * @return the id
	 */
	public PK getId();

	/**
	 * @param id the id to set
	 */
	public void setId(PK id);
}
