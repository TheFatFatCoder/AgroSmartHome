package id.ac.sgu.SmartHome.AbstractClasses;

import java.util.Observable;

import Interfaces.Sensor;

public abstract class AbstractSensor extends Observable implements Sensor{
	protected float value;
	
	public abstract void setValue(float x);
	
	public float getValue() {
		return this.value;
	}
}
