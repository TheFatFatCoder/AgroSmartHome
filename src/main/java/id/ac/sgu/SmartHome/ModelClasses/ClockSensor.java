package id.ac.sgu.SmartHome.ModelClasses;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class ClockSensor extends AbstractSensor{
	
	public ClockSensor() {
		type = "clock";
	}

	@Override
	public void setValue(Object x) {
		String time = x.toString();
		value = DateTimeConverter.convertTime(time);
		setChanged();
		notifyObservers();
	}
	
}
