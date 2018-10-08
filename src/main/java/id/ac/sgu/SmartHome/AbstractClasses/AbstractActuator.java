package id.ac.sgu.SmartHome.AbstractClasses;

import java.util.Observable;

import id.ac.sgu.SmartHome.Interfaces.Actuator;

public abstract class AbstractActuator extends Observable implements Actuator{
	protected Object currState;

	@Override
	public abstract void doAction(Object action, String arg);
	
	public Object getState() {
		return this.currState;
	}
}
