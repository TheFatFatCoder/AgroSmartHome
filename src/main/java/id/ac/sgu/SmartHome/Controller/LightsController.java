package id.ac.sgu.SmartHome.Controller;

import java.sql.Time;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.ModelClasses.Blinds;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.Lights;
import id.ac.sgu.SmartHome.ModelClasses.WindSensor;

public class LightsController extends AbstractController implements Observer{

	private Lights lights;
	private ClockSensor clockSensor;
	private int onTimeStart;
	private int onTimeEnd;
	
	public LightsController(Lights lights, ClockSensor clockSensor) {
		this.lights = lights;
		this.clockSensor = clockSensor;
		onTimeStart = 7;
		onTimeEnd = 18;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		int hour = ((Time) clockSensor.getValue()).getHours();
		if(hour > onTimeStart && hour < onTimeEnd) {	// Turn Off Lights
			lights.doAction(false, "");
			view.turnOnLights(false);
		} else {										// Turn On Lights
			lights.doAction(true, "");
			view.turnOnLights(true);
		}
	}

	public int getOnTimeStart() {
		return onTimeStart;
	}

	public void setOnTimeStart(int onTimeStart) {
		this.onTimeStart = onTimeStart;
	}

	public int getOnTimeEnd() {
		return onTimeEnd;
	}

	public void setOnTimeEnd(int onTimeEnd) {
		this.onTimeEnd = onTimeEnd;
	}
}
