package id.ac.sgu.SmartHome.Controller;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.ModelClasses.Alarm;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.DateTimeConverter;
import id.ac.sgu.SmartHome.ModelClasses.DoorLock;

public class DoorController extends AbstractController implements Observer{
	
	private Alarm alarm;
	private ClockSensor clockSensor;
	private DoorLock lock;
	private LocalDateTime onTime;
	private LocalDateTime offTime;
	
	public DoorController(Alarm alarm, ClockSensor clockSensor, DoorLock lock) {
		this.alarm = alarm;
		this.clockSensor = clockSensor;
		this.lock = lock;
		this.onTime = DateTimeConverter.convertTime("19:00:00");
		this.offTime = DateTimeConverter.convertTime("05:00:00");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		AbstractSensor sensor = (AbstractSensor) arg0;
		if	(timeWithinOnRange(sensor.getValue()) && sensor.getType().equals("doorlock")) {
			lock.setValue(true);
		}
	}
	
	public void openDoor() {
		this.lock.openLock();
	}
	
	private boolean timeWithinOnRange(Object param) {
		return offTime.isAfter((LocalDateTime) param) && onTime.isBefore((LocalDateTime) param);
	}

}
