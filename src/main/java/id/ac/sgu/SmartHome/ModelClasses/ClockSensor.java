package id.ac.sgu.SmartHome.ModelClasses;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.Util.DateTimeConverter;

public class ClockSensor extends AbstractSensor{
	
	public ClockSensor() {
		type = "clock";
	}

	@Override
	public void setValue(Object x) {
		value = DateTimeConverter.convertTime(x.toString());
		try {
			if	(((LocalDateTime) value).isBefore(LocalDateTime.now())) {
				value = ((LocalDateTime) value).plusDays(1);
			}
			setChanged();
			notifyObservers();
		} catch(NullPointerException e) {}
	}
	
}
