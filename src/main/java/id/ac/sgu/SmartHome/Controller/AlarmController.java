package id.ac.sgu.SmartHome.Controller;

import java.sql.Time;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.ModelClasses.Alarm;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.DoorSensor;

public class AlarmController extends AbstractController implements Observer {
	
	private Alarm alarm;
	private ClockSensor clockSensor;
	private DoorSensor doorSensor;
	private int onTimeStart;
	private int onTimeEnd;
	
	public AlarmController(Alarm alarm, DoorSensor doorSensor, ClockSensor clockSensor) {
		this.alarm = alarm;
		this.doorSensor = doorSensor;
		this.clockSensor = clockSensor;
		onTimeStart = 23;
		onTimeEnd = 5;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int hour = ((Time) clockSensor.getValue()).getHours();
		if(hour > onTimeStart && hour < onTimeEnd) {	// Alarm disarm
			alarm.doAction(false, "");
			view.turnOnLights(false);
		} 
	}
}