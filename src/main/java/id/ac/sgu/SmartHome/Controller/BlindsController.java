package id.ac.sgu.SmartHome.Controller;

import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.ModelClasses.Blinds;
import id.ac.sgu.SmartHome.ModelClasses.WindSensor;
import id.ac.sgu.SmartHome.View.MainView;

public class BlindsController extends AbstractController implements Observer {
	
	private Blinds blinds;
	private WindSensor windSensor;
	private int knotsThreshold;

	public BlindsController(Blinds blinds, WindSensor windSensor) {
		this.blinds = blinds;
		this.windSensor = windSensor;
		this.knotsThreshold = 25;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if((Double) windSensor.getValue() < knotsThreshold) { 	// Turn Off Blinds
			blinds.doAction(false, "");
			view.turnOnBlinds(false);
		} else {												// Turn On Blinds
			blinds.doAction(true, "");
			view.turnOnBlinds(true);
		}
	}
	
	public int getKnotsThreshold() {
		return knotsThreshold;
	}

	public void setKnotsThreshold(int knotsThreshold) {
		this.knotsThreshold = knotsThreshold;
	}
}
