package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import org.junit.Test;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.Interfaces.Sensor;
import id.ac.sgu.SmartHome.ModelClasses.TempSensor;

public class TempSensorTest {

	@Test
	public void test() {
		Sensor sensor = new TempSensor();
		sensor.setValue(5.1);
		System.out.println(sensor.getValue());
		assertEquals( 5.1, (double) sensor.getValue(), 0.01);
	}
}
