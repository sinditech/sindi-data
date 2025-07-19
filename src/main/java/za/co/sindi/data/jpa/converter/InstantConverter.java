/**
 * 
 */
package za.co.sindi.data.jpa.converter;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Buhake Sindi
 * @since 19 February 2024
 */
@Converter(autoApply = true)
public class InstantConverter implements AttributeConverter<Instant, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(Instant instant) {
		// TODO Auto-generated method stub
		return instant == null ? null : Timestamp.from(instant);
	}

	@Override
	public Instant convertToEntityAttribute(Timestamp timestamp) {
		// TODO Auto-generated method stub
		return timestamp == null ? null : timestamp.toInstant();
	}
}
