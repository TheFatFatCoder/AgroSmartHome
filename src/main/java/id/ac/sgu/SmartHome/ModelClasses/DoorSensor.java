package id.ac.sgu.SmartHome.ModelClasses;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class DoorSensor extends AbstractSensor {

	@Override
	public void setValue(Object x) {
		setChanged();
		notifyObservers();
	}

}
