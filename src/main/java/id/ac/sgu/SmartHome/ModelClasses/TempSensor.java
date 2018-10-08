package id.ac.sgu.SmartHome.ModelClasses;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class TempSensor extends AbstractSensor{

	public TempSensor() {
		super();
	}
	
	@Override
	public void setValue(Object val) {
		// TODO Auto-generated method stub
		value = (double) val;
		setChanged();
		notifyObservers(this.value);
	}
}
