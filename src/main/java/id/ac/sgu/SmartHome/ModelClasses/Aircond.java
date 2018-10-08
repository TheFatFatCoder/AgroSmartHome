package id.ac.sgu.SmartHome.ModelClasses;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.Interfaces.Actuator;
import id.ac.sgu.SmartHome.Interfaces.Sensor;

public class Aircond extends AbstractActuator implements Observer{
	private int desiredTemp;
	private double lastTempPerceived;
	private LocalDateTime onTime;
	private LocalDateTime offTime;
	private LocalDateTime lastTimePerceived;
	
	public Aircond() {}
	
	public Aircond(int desiredTemp) {
		setDesiredTemp(desiredTemp);
		setTime(null, null);
	}
	
	public Aircond(int desiredTemp, LocalDateTime onTime, LocalDateTime offTime) {
		setDesiredTemp(desiredTemp);
		setTime(onTime, offTime);
	}
	
	public void setTime(LocalDateTime onTime, LocalDateTime offTime) {
		if	(onTime.getHour()>12 && offTime.getHour()<12) {
				this.offTime = offTime.plusDays(1);
				this.onTime = onTime;
		}else {
			this.onTime = onTime;
			this.offTime = offTime;
		}
	}
	
	public void setDesiredTemp(int desiredTemp) {
		this.desiredTemp = desiredTemp;
		doAction(lastTempPerceived, "temp");
	}
	
	@Override
	public void doAction(Object param, String arg) {
		if	(isTempArg(arg)) {
			if	(isLowerThanDesiredTemp(param)) {
				this.currState = false;
				setChanged();
				notifyObservers(this.currState);
			}else {
				if	(timerHasBeenSet()) {
					if	(timeWithinOnRange(lastTimePerceived)) {
						this.currState = true;
						setChanged();
						notifyObservers(this.currState);
					}else {
						this.currState = false;
						setChanged();
						notifyObservers(this.currState);
					}
				}else{
					this.currState = true;
					setChanged();
					notifyObservers(this.currState);
				}
			}
		}else if (isTimeArg(arg)) {
			if	(timeWithinOnRange(param)) {
				this.currState = true;
				setChanged();
				notifyObservers(this.currState);
			}else {
				this.currState = false;
				setChanged();
				notifyObservers(this.currState);
			}
		}
	}

	private boolean timeWithinOnRange(Object param) {
		boolean feckMe = offTime.isAfter((LocalDateTime) param) && onTime.isBefore((LocalDateTime) param);
		System.out.println(feckMe);
		return feckMe;
	}

	private boolean timerHasBeenSet() {
		return onTime != null || offTime != null;
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
		AbstractSensor sensor = (AbstractSensor) o;
		if	(sensor.getType().equals("clock")) {
			this.lastTimePerceived = (LocalDateTime) sensor.getValue();
		}else if (sensor.getType().equals("temp")) {
			this.lastTempPerceived = (double) sensor.getValue();
		}
		doAction(sensor.getValue(), sensor.getType());
	}
}
