package id.ac.sgu.SmartHome.ModelClasses;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.Interfaces.Actuator;
import id.ac.sgu.SmartHome.Interfaces.Sensor;

public class Aircond extends AbstractActuator implements Observer{
	private int desiredTemp;
	private Time onTime;
	private Time offTime;
	private Time lastTimePerceived;
	
	public Aircond(int desiredTemp) {
		this.desiredTemp = desiredTemp;
		setTime(null, null);
	}
	
	public Aircond(int desiredTemp, Time onTime, Time offTime) {
		this.desiredTemp = desiredTemp;
		setTime(onTime, offTime);
	}
	
	public void setTime(Time onTime, Time offTime) {
		this.onTime = onTime;
		this.offTime = offTime;
	}

	@Override
	public void doAction(Object param, String arg) {
		// TODO Auto-generated method stub
		if	(isTempArg(arg)) {
			if	(isLowerThanDesiredTemp(param)) {
				this.currState = false;
			}else {
				if	(timerHasBeenSet()) {
					if	(timeWithinOnRange(lastTimePerceived)) {
						this.currState = true;
					}else {
						this.currState = false;
					}
				}else{
					this.currState = true;
				}
			}
		}else if (isTimeArg(arg)) {
			if	(timeWithinOnRange(param)) {
				this.currState = true;
			}else {
				this.currState = false;
			}
		}
	}

	private boolean timeWithinOnRange(Object param) {
		return offTime.after((Time) param) && onTime.before((Time) param);
	}

	private boolean timerHasBeenSet() {
		return onTime != null && offTime != null;
	}

	private boolean isTimeArg(String arg) {
		return arg.equals("clock");
	}

	private boolean isLowerThanDesiredTemp(Object param) {
		return (double) param < desiredTemp;
	}

	private boolean isTempArg(String arg) {
		return arg.equals("temp");
	}
	
	public void setState(boolean state) {
		this.currState = state;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		AbstractSensor sensor = (AbstractSensor) o;
		if	(sensor.getType().equals("clock")) {
			this.lastTimePerceived = (Time) sensor.getValue();
		}
		doAction(sensor.getValue(), sensor.getType());
	}
}
