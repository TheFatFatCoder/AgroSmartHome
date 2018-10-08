package id.ac.sgu.SmartHome.ModelClasses;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class ClockSensor extends AbstractSensor{
	private LocalDateTime timeNow;
	
	public ClockSensor() {
		timeNow = LocalDateTime.now();
		type = "clock";
	}

	@Override
	public void setValue(Object x) {
		// TODO Auto-generated method stub
		String time = x.toString();
		String[] hourAndMinute = time.split(":");
		int hour = Integer.parseInt(hourAndMinute[0]);
		int minute = Integer.parseInt(hourAndMinute[1]);
		//int second = Integer.parseInt(hourAndMinute[2]);
		timeNow =  LocalTime.parse(hour+":"+minute).atDate(LocalDate.now());
		value = timeNow;
		setChanged();
		notifyObservers();
	}
	
}
