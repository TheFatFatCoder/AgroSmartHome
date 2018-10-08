package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import org.junit.Test;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.ModelClasses.Alarm;

public class AlarmTest {

	@Test
	public void test() {
		Alarm alarm = new Alarm();
		alarm.doAction(true, "");
		assertEquals(true, alarm.getState());
	}
}
