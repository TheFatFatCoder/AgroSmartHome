package id.ac.sgu.SmartHome.ModelClasses;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

public class DoorLock extends AbstractSensor{
	private Alarm alarm;
	
	public DoorLock(Alarm alarm) {
		this.alarm = alarm;
		
	}
	
	private void armLock() {
		this.value = true;
	}
	
	private void disarmLock() {
		this.value = false;
	}

	public void openLock() {
		if	(lockIsArmed()) {
			alarm.doAction(true, null);
		}
	}

	private boolean lockIsArmed() {
		return (boolean) this.value == true;
	}
	@Override
	public void setValue(Object x) {
		// TODO Auto-generated method stub
		if	(isTrue(x)) {
			armLock();
		}else {
			disarmLock();
		}
	}

	private boolean isTrue(Object x) {
		return (boolean) x == true;
	}

}
