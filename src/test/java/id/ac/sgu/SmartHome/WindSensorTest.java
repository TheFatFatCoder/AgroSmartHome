package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import org.junit.Test;

import Interfaces.Sensor;
import id.ac.sgu.SmartHome.ModelClasses.WindSensor;

public class WindSensorTest {

	@Test
	public void test() {
		Sensor sensor = new WindSensor();
		sensor.setValue(1055.00); //1055 rpm
		assertEquals(1055, (double) sensor.getValue(), 0.1);
	}

}
