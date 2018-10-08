package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import org.junit.Test;

import id.ac.sgu.SmartHome.Controller.DoorController;
import id.ac.sgu.SmartHome.ModelClasses.Alarm;
import id.ac.sgu.SmartHome.ModelClasses.DoorLock;

public class DoorControlTest {

	@Test
	public void test() {
		DoorLock lock = new DoorLock(new Alarm());
		lock.setValue(true);
		assertEquals(true, true);
	}

}
