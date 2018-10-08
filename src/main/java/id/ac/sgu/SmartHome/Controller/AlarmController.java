package id.ac.sgu.SmartHome.Controller;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.ModelClasses.Alarm;

public class AlarmController extends AbstractController{
	private Alarm alarm;
	
	public AlarmController(Alarm alarm) {
		this.alarm = alarm;
	}
}