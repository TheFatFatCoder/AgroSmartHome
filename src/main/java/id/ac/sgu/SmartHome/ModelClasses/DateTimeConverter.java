package id.ac.sgu.SmartHome.ModelClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {
	private LocalDateTime dateTime;
	
	private DateTimeConverter(String dateTimeStr) {
		String[] hourAndMinute = dateTimeStr.split(":");
		int hour = Integer.parseInt(hourAndMinute[0]);
		int minute = Integer.parseInt(hourAndMinute[1]);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		this.dateTime =  LocalTime.parse(hour+":"+minute, dateTimeFormatter).atDate(LocalDate.now());
	}
	
	public static LocalDateTime convertTime(String dateTimeStr) {
		return new DateTimeConverter(dateTimeStr).dateTime;
	}
}
