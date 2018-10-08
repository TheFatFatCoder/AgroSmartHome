package id.ac.sgu.SmartHome.ModelClasses;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.Interfaces.Actuator;
import id.ac.sgu.SmartHome.Interfaces.Sensor;

public class Aircond extends AbstractActuator{
	private int desiredTemp;
	private AbstractSensor sourceSensor;
	
	public Aircond(int desiredTemp) {
		this.desiredTemp = desiredTemp;
		sourceSensor.addObserver(sensor);
		
	}

	@Override
	public void doAction(Object action, String arg) {
		// TODO Auto-generated method stub
		
	}
	
}
