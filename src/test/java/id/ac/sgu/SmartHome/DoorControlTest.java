package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import org.junit.Test;

import id.ac.sgu.SmartHome.Controller.DoorController;
import id.ac.sgu.SmartHome.ModelClasses.Alarm;
import id.ac.sgu.SmartHome.ModelClasses.DoorLockSensor;

public class DoorControlTest {

	@Test
	public void test() {
		DoorLockSensor lock = new DoorLockSensor(new Alarm());
		lock.setValue(true);
		assertEquals(true, true);
	}

}
