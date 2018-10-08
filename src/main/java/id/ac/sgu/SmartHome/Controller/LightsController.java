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
	
	public LightsController(Lights lights, ClockSensor clockSensor) {
		this.lights = lights;
		this.clockSensor = clockSensor;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		int hour = ((Time) clockSensor.getValue()).getHours();
		if(hour > 7 && hour < 18) {		// Turn Off Lights
			lights.doAction(false, "");
			view.turnOnLights(false);
		} else {						// Turn On Lights
			lights.doAction(true, "");
			view.turnOnLights(true);
		}
	}

}
