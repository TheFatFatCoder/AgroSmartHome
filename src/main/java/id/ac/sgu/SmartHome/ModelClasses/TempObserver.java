package id.ac.sgu.SmartHome.ModelClasses;

import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class TempObserver implements Observer{
	
	private AbstractSensor tempSensor;
	
	public TempObserver(TempSensor sensor) {
		tempSensor = sensor;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		tempSensor = (AbstractSensor) o;
	}
	
}
