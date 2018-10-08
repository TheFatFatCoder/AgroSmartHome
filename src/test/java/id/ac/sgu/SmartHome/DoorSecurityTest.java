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
		lock.openLock();
		assertEquals(true, alarm.getState());
		alarm.doAction(false, null);
		assertEquals(false, alarm.getState());
	}

}
