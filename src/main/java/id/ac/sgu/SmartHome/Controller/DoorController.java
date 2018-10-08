package id.ac.sgu.SmartHome.Controller;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.ModelClasses.DoorLock;

public class DoorController extends AbstractController implements Observer{
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private DoorLock lock;
	
	public DoorController(DoorLock lock, AbstractSensor clockSensor ,LocalDateTime start, LocalDateTime end) {
		this.lock = lock;
		this.startTime = start;
		this.endTime = end;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		AbstractSensor sensor = (AbstractSensor) arg0;
		if	(timeWithinOnRange(sensor.getValue()) && sensor.getType().equals("doorlock")) {
			lock.setValue(true);
		}
	}
	
	public void openDoor() {
		this.lock.openLock();
	}
	
	private boolean timeWithinOnRange(Object param) {
		return endTime.isAfter((LocalDateTime) param) && startTime.isBefore((LocalDateTime) param);
	}

}
