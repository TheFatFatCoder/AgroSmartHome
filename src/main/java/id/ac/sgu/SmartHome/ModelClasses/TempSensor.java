package id.ac.sgu.SmartHome.ModelClasses;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class TempSensor extends AbstractSensor{

	public TempSensor() {
		super();
		type = "temp";
	}
	
	@Override
	public void setValue(Object val) {
		try {
			value = Double.parseDouble(val.toString());
			setChanged();
			notifyObservers(value);
		} catch(NumberFormatException e) {}
	}
}
