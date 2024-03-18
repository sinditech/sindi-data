/**
 * 
 */
package za.co.sindi.data.repository;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.enterprise.inject.Stereotype;

/**
 * @author Buhake Sindi
 * @since 13 September 2023
 */
@Documented
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@jakarta.data.repository.Repository
public @interface Repository {

}
