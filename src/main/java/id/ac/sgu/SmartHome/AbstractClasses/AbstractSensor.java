package id.ac.sgu.SmartHome.AbstractClasses;

import java.util.Observable;

import Interfaces.Sensor;

public abstract class AbstractSensor extends Observable implements Sensor{
	protected Object value;
	
	public abstract void setValue(Object x);
	
	public Object getValue() {
		return this.value;
	}
}
