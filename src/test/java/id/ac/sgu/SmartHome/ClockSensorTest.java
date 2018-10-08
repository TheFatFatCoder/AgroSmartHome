package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import org.junit.Test;

import id.ac.sgu.SmartHome.Interfaces.Sensor;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;

public class ClockSensorTest {
	@Test
	public void test() {
		Sensor clockSensor = new ClockSensor("10:30:00");
		System.out.println(clockSensor.getValue().toString());
		assertEquals("10:30:00", clockSensor.getValue().toString());
	}
}