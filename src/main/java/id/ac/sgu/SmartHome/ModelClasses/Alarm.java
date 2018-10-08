package id.ac.sgu.SmartHome.ModelClasses;


import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

public class Alarm extends AbstractActuator{
	
	public Alarm() {
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
		// TODO Auto-generated method stub
		if	(isTrue(action)) {
			setArm();
		}else {
			setDisarm();
		}
	}

	private boolean isTrue(Object action) {
		return (boolean)action==true;
	}
	
}
