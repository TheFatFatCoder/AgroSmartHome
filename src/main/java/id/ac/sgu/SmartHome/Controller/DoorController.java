package id.ac.sgu.SmartHome.Controller;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.ModelClasses.Alarms;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.DoorLockSensor;
import id.ac.sgu.SmartHome.Util.DateTimeConverter;

public class DoorController extends AbstractController implements Observer{
	
	private Alarms alarm;
	private ClockSensor clockSensor;
	private DoorLockSensor lock;
	private LocalDateTime onTime;
	private LocalDateTime offTime;
	
	public DoorController(Alarms alarm, ClockSensor clockSensor, DoorLockSensor lock) {
		this.alarm = alarm;
		this.onTime = DateTimeConverter.convertTime("19:00:00");
		this.offTime = DateTimeConverter.convertTime("05:00:00");
		this.alarm.setTimes(onTime, offTime);
		this.clockSensor = clockSensor;
		this.lock = lock;
		clockSensor.addObserver(this.alarm);
		this.alarm.addObserver(this);
	}

	@Override
	public void update(Observable obj, Object arg1) {
		if(obj instanceof DoorLockSensor) {
			if((Boolean) alarm.getState()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Intruder Alert");
				alert.setHeaderText("Alarm ringing");
				alert.setContentText("RING RING ");
				alert.showAndWait();
				System.out.println("after this");
			} else {
				System.out.println("door opened");
			}
		} else if(obj instanceof Alarms) {
			if((Boolean) alarm.getState()) {
				view.turnOnAlarm(true);
			} else {
				view.turnOnAlarm(false);
			}
		}
	}
	
	public void openDoor() {
		this.lock.openLock();
	}
}
