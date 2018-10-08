package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import org.junit.Test;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.ModelClasses.Alarm;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.DateTimeConverter;

public class AlarmTest {
	@Test
	public void test() {
		AbstractSensor clock = new ClockSensor();
		Alarm alarm = new Alarm(DateTimeConverter.convertTime("20:00:00"), DateTimeConverter.convertTime("05:00:00"));
		clock.addObserver(alarm);
		clock.setValue("23:00:00");
		assertEquals(true, alarm.getState());
	}
}