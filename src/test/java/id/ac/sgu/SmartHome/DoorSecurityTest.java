package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import org.junit.Test;
import id.ac.sgu.SmartHome.ModelClasses.Alarm;
import id.ac.sgu.SmartHome.ModelClasses.DoorLock;

public class DoorSecurityTest {

	@Test
	public void test() {
		Alarm alarm = new Alarm();
		DoorLock lock = new DoorLock(alarm);
		lock.setValue(true);
		assertEquals(false, alarm.getState());
		alarm.doAction(true, null);
		assertEquals(true, alarm.getState());
	}

}
