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
	public void playSound() {
		try {
			AudioClip clip = Applet.newAudioClip(new URL("file: /home/john/eclipse-workspace/AgroSmartHome/src/main/java/id/ac/sgu/SmartHome/Media/fire-truck-air-horn_daniel-simio.wav"));
			clip.play();
			TimeUnit.SECONDS.sleep(10);
			System.out.println("played");
		}catch (MalformedURLException murle) {
			System.out.println(murle);
		}catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@Override
	public void doAction(Object action, String arg) {
		// TODO Auto-generated method stub
		
	}
}
