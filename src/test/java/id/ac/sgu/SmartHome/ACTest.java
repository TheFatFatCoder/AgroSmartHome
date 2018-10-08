package id.ac.sgu.SmartHome;

import static org.junit.Assert.*;

import java.sql.Time;

import org.junit.Test;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.Interfaces.Actuator;
import id.ac.sgu.SmartHome.Interfaces.Sensor;
import id.ac.sgu.SmartHome.ModelClasses.Aircond;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.TempSensor;

public class ACTest {

	@Test
	public void test() {
		Time timeOn = new Time(9, 00, 00);
		Time timeOff = new Time(10, 00, 00);
		Aircond aircond = new Aircond(18, timeOn, timeOff);
		AbstractSensor clockSensor = new ClockSensor(); AbstractSensor tempSensor = new TempSensor(); 
        clockSensor.addObserver(aircond); tempSensor.addObserver(aircond); 
        clockSensor.setValue("9:30:00");
        tempSensor.setValue(20.0);
        assertEquals(true, aircond.getState());
        tempSensor.setValue(17.00);
        assertEquals(false, aircond.getState());
        clockSensor.setValue("11:30:00");
        tempSensor.setValue(21.0);
        assertEquals(false, aircond.getState());
        aircond.setDesiredTemp(22);
	}
}