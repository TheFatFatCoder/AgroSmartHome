package id.ac.sgu.SmartHome.ModelClasses;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;

public class Blinds extends AbstractActuator {
	private boolean state;
	
	public Blinds() {
		this.state = false;
	}

	@Override
	public void doAction(Object action, String arg) {
		
	}

}
