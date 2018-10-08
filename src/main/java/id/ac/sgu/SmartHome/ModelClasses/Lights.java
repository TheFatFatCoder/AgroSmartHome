package id.ac.sgu.SmartHome.ModelClasses;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;

public class Lights extends AbstractActuator {

	@Override
	public void doAction(Object action, String arg) {
		currState = (Boolean) action;
	}
}