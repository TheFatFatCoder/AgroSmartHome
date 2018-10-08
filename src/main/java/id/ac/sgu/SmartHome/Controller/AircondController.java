package id.ac.sgu.SmartHome.Controller;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.ModelClasses.Airconds;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.TempSensor;
import id.ac.sgu.SmartHome.Util.DateTimeConverter;

public class AircondController extends AbstractController implements Observer {
	
	private Airconds aircond;
	private TempSensor tempSensor;
	private ClockSensor clockSensor;
	private LocalDateTime onTime;
	private LocalDateTime offTime;
	private int desiredTemp;
	
	public AircondController(Airconds aircond, TempSensor tempSensor, ClockSensor clockSensor) {
		this.aircond = aircond;
		this.tempSensor = tempSensor;
		this.clockSensor = clockSensor;
		onTime = DateTimeConverter.convertTime("19:00:00");
		offTime = DateTimeConverter.convertTime("05:00:00");
		desiredTemp = 22;
		this.aircond.setDesiredTemp(desiredTemp);
		this.aircond.setTime(onTime, offTime);
		tempSensor.addObserver(this.aircond);
		clockSensor.addObserver(this.aircond);
		this.aircond.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if((Boolean) aircond.getState()) {
			view.turnOnAircon(true);
		} else {
			view.turnOnAircon(false);
		}
	}
	
	public Airconds getAircond() {
		return this.aircond;
	}
}
