package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;

import id.ac.sgu.SmartHome.Interfaces.Sensor;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;

public class ClockSensorTest {
	@Test
	public void test() {
		Sensor clockSensor = new ClockSensor();
		clockSensor.setValue("10:30:00");
		LocalDateTime result = (LocalDateTime) clockSensor.getValue();
		System.out.println(result.getHour());
		assertEquals(10, result.getHour());
	}
}