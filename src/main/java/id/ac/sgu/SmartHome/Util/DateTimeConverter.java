package id.ac.sgu.SmartHome.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeConverter {
	private LocalDateTime dateTime;
	
	private DateTimeConverter(String dateTimeStr) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		try {
			this.dateTime =  LocalTime.parse(dateTimeStr, dateTimeFormatter).atDate(LocalDate.now());
		} catch(DateTimeParseException e) {}
	}
	
	public static LocalDateTime convertTime(String dateTimeStr) {
		return new DateTimeConverter(dateTimeStr).dateTime;
	}
}
