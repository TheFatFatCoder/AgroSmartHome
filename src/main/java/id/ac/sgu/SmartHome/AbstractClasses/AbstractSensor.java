package id.ac.sgu.SmartHome.AbstractClasses;

import java.util.Observable;

public abstract class AbstractSensor extends Observable{
	float value;
	public abstract void setValue(float value);
}
