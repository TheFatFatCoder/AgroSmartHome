package id.ac.sgu.SmartHome.AbstractClasses;

import Interfaces.Actuator;

public abstract class AbstractActuator implements Actuator {
	
	@Override
	public abstract void doAction();
}
