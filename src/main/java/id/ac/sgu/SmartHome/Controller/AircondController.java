package id.ac.sgu.SmartHome.Controller;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.ModelClasses.Aircond;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.DateTimeConverter;
import id.ac.sgu.SmartHome.ModelClasses.TempSensor;

public class AircondController extends AbstractController implements Observer {
	
	private Aircond aircond;
	private TempSensor tempSensor;
	private ClockSensor clockSensor;
	private LocalDateTime onTime;
	private LocalDateTime offTime;
	private int desiredTemp;
	
	public AircondController(Aircond aircond, TempSensor tempSensor, ClockSensor clockSensor) {
		this.aircond = aircond;
		this.tempSensor = tempSensor;
		this.clockSensor = clockSensor;
		onTime = DateTimeConverter.convertTime("19:00");
		onTime = DateTimeConverter.convertTime("05:00");
		desiredTemp = 22;
		this.aircond.setDesiredTemp(desiredTemp);
		this.aircond.setTime(onTime, offTime);
		tempSensor.addObserver(this.aircond);
		clockSensor.addObserver(this.aircond);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if((Boolean) aircond.getState()) {
			view.turnOnAircon(true);
//			System.out.println("ON");
		} else {
			view.turnOnAircon(false);
//			System.out.println("OFF");
		}
	}
	
	public Aircond getAircond() {
		return this.aircond;
	}
}
