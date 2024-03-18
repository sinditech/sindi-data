/**
 * 
 */
package za.co.sindi.data.jpa.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Buhake Sindi
 * @since 19 February 2024
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		// TODO Auto-generated method stub
		return attribute == null ? null : Timestamp.valueOf(attribute);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		// TODO Auto-generated method stub
		return dbData == null ? null : dbData.toLocalDateTime();
	}
}
