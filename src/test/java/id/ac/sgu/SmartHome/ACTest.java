package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import org.junit.Test;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.Interfaces.Actuator;
import id.ac.sgu.SmartHome.Interfaces.Sensor;
import id.ac.sgu.SmartHome.ModelClasses.Aircond;
import id.ac.sgu.SmartHome.ModelClasses.TempSensor;

public class ACTest {

	@Test
	public void test() {
		Aircond aircond = new Aircond(18);
        AbstractSensor tempSensor = new TempSensor();
        tempSensor.addObserver(aircond);
        tempSensor.setValue(20.0);
        System.out.println(aircond.getState());
        tempSensor.setValue(17.00);
        System.out.println(aircond.getState());
	}
}