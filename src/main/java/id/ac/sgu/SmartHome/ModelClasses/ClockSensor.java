package id.ac.sgu.SmartHome.ModelClasses;

import java.sql.Time;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class ClockSensor extends AbstractSensor{
	private Time timeNow;
	
	public ClockSensor(String time) {
		setValue(time);
	}

	@Override
	public void setValue(Object x) {
		// TODO Auto-generated method stub
		String time = x.toString();
		String[] hourAndMinute = time.split(":");
		int hour = Integer.parseInt(hourAndMinute[0]);
		int minute = Integer.parseInt(hourAndMinute[1]);
		int second = Integer.parseInt(hourAndMinute[2]);
		timeNow = new Time(hour, minute, second);
		value = timeNow;
		setChanged();
		notifyObservers();
	}
	
}
