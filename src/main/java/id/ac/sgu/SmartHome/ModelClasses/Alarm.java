package id.ac.sgu.SmartHome.ModelClasses;


import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.applet.*;
import java.net.*;

import id.ac.sgu.SmartHome.*;

public class Alarm extends AbstractActuator implements Observer {
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private ClockSensor clockSensor;
	
	public Alarm(LocalDateTime startTime, LocalDateTime endTime, ClockSensor clockSensor) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.clockSensor = clockSensor;
		setDisarm();
	}
	
	private void setArm() {
		this.currState = true;
	}
	
	private void setDisarm() {
		this.currState = false;
	}

	@Override
	public void doAction(Object action, String arg) {
		if	(isTrue(action)) {
			setArm();
		}else {
			setDisarm();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		AbstractSensor sensor = (ClockSensor) o;
		LocalDateTime sensorDt = (LocalDateTime)sensor.getValue();
		if	(timeWithinOnRange(sensorDt) && sensor.getType().equals("doorlock")) {
			doAction(true, null);
		}else {
			doAction(false, null);
		}
	}
	
	private boolean timeWithinOnRange(Object param) {
		return endTime.isBefore((LocalDateTime) param) && startTime.isAfter((LocalDateTime) param);
	}
	
	private boolean isTrue(Object action) {
		return (boolean)action==true;
	}
	
}
