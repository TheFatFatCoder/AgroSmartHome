package id.ac.sgu.SmartHome.ModelClasses;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class DoorController extends AbstractSensor {

	@Override
	public void setValue(Object x) {
		setChanged();
		notifyObservers();
	}

}
