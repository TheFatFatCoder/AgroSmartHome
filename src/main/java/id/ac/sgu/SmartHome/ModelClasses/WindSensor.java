package id.ac.sgu.SmartHome.ModelClasses;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class WindSensor extends AbstractSensor{
	@Override
	public void setValue(Object rpm) {
		// TODO Auto-generated method stub
		value = (double) rpm;
		/*
		 * 	here RPM has to be converted to knots or mph or kmph
		 */
		setChanged();
		notifyObservers(value);
	}
}
