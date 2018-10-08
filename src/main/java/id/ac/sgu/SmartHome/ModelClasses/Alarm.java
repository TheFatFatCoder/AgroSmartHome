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
	private boolean isRing;
	
	public Alarm() {
		setDisarm();
	}
	
	public Alarm(LocalDateTime startTime, LocalDateTime endTime) {
		setTimes(startTime, endTime);
		setDisarm();
	}
	
	public void setTimes(LocalDateTime startTime, LocalDateTime endTime) {
		if	(startTime.getHour()>12 && endTime.getHour()<12) {
			this.endTime = endTime.plusDays(1);
			this.startTime = startTime;
		}else {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	
	private void setArm() {
		this.currState = true;
	}
	
	private void setDisarm() {
		this.currState = false;
	}

	public void setRing() {
		this.isRing = true;
	}
	
	public void unsetRing() {
		this.isRing = false;
	}
	
	public boolean getRingStatus() {
		return this.isRing;
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
		if	(timeWithinOnRange(sensorDt)) {
			doAction(true, null);
		}else {
			doAction(false, null);
		}
	}
	
	private boolean timeWithinOnRange(Object param) {
		try {
			if(startTime == null) {
				System.out.println("start null yo");
			}
			if(endTime == null) {
				System.out.println("end null yo");
			}
			boolean status = startTime.isBefore((LocalDateTime) param) && endTime.isAfter((LocalDateTime) param);
			return status;
		} catch(Exception e) {}
		return false;
	}
	
	private boolean isTrue(Object action) {
		return (boolean)action==true;
	}	
}