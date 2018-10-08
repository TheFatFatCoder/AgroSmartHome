package id.ac.sgu.SmartHome.Controller;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.ModelClasses.Alarm;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.DateTimeConverter;
import id.ac.sgu.SmartHome.ModelClasses.DoorLock;

public class DoorController extends AbstractController implements Observer{
	
	private Alarm alarm;
	private DoorLock doorLock;
	private ClockSensor clockSensor;
	private LocalDateTime onTime;
	private LocalDateTime offTime;
	
	public DoorController(Alarm alarm, DoorLock doorLock, ClockSensor clockSensor) {
		this.alarm = alarm;
		this.doorLock = doorLock;
		this.clockSensor = clockSensor;
		onTime = DateTimeConverter.convertTime("19:00:00");
		offTime = DateTimeConverter.convertTime("05:00:00");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	
	private boolean timeWithinOnRange(Object param) {
		return offTime.isAfter((LocalDateTime) param) && onTime.isBefore((LocalDateTime) param);
	}

}
