package id.ac.sgu.SmartHome.ModelClasses;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class WindSensor extends AbstractSensor{
	@Override
	public void setValue(Object rpm) {
		try {
			value = Double.parseDouble(rpm.toString());
			setChanged();
			notifyObservers(value);
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
