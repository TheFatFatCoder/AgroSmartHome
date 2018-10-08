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

public class Aircond extends AbstractActuator implements Observer{
	private int desiredTemp;
	
	public Aircond(int desiredTemp) {
		this.desiredTemp = desiredTemp;
	}

	@Override
	public void doAction(Object param, String arg) {
		// TODO Auto-generated method stub
		if	(arg.equals("temp")) {
			if	((double) param < desiredTemp) {
				this.currState = false;
			}else {
				this.currState = true;
			}
		}
	}
	
	public void setState(boolean state) {
		this.currState = state;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		AbstractSensor tempSensor = (TempSensor) o;
		doAction(tempSensor.getValue() , "temp");
	}
}
