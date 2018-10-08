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
	private int desiredTemperature;
	private Time timeON;
	private Time timeOFF;
	private List<Observable> sensors;
	
	public Aircond(Observable obs) {
		desiredTemperature = 18;
		initialiseSensor(obs);
	}
	
	public Aircond(int desiredTemperature, Observable obs) {
		this.desiredTemperature = desiredTemperature;
		initialiseSensor(obs);
	}
	
	public void initialiseSensor(Observable obs) {
		sensors = new ArrayList<Observable>();
		sensors.add(obs);
	}
	
	@Override
	public void doAction(Object object, String arg) {
		// TODO Auto-generated method stub
		if			(isArgTemp(arg)) {
					desiredTemperature = (int) object;
					update(sensors.get(0), arg);
		}else if	(arg.equals("time")) {
					
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if	(isArgTemp(arg)) {
			AbstractSensor sense = (AbstractSensor) o;
			System.out.println(sense.getValue());
			if	(Double.parseDouble(sense.getValue().toString()) < desiredTemperature) {
				currState = false;
			}else if (Double.parseDouble(sense.getValue().toString()) > desiredTemperature) {
				currState = true;
			}
		}
	}
	
	private boolean isArgTemp(Object arg) {
		return arg.toString().equals("temp");
	}

	
}
