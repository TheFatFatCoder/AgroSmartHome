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
		AbstractSensor tempSensor = new TempSensor();
		Actuator aircond = new Aircond(18);
		tempSensor.setValue(19.00); //Input double param
		aircond.doAction(18, "temp");
		
		tempSensor.setValue(17.00);
		assertEquals(true, aircond.getState()); //##PROBLEM, EXPECT SHOULD BE FALSE...
	}
}