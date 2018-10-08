package id.ac.sgu.SmartHome.ModelClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {
	private LocalDateTime dateTime;
	
	private DateTimeConverter(String dateTimeStr) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		this.dateTime =  LocalTime.parse(dateTimeStr, dateTimeFormatter).atDate(LocalDate.now());
	}
	
	public static LocalDateTime convertTime(String dateTimeStr) {
		return new DateTimeConverter(dateTimeStr).dateTime;
	}
}
