package id.ac.sgu.SmartHome.Controller;

import java.util.ArrayList;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.ModelClasses.ClockSensor;
import id.ac.sgu.SmartHome.ModelClasses.DoorLock;
import id.ac.sgu.SmartHome.ModelClasses.TempSensor;
import id.ac.sgu.SmartHome.ModelClasses.WindSensor;
import id.ac.sgu.SmartHome.View.MainView;

public class MainController extends AbstractController {
	
	private ArrayList<AbstractController> controllerList;
	private ArrayList<AbstractSensor> sensorList;
	
	public MainController() {
		controllerList = new ArrayList<AbstractController>();
		sensorList = new ArrayList<AbstractSensor>();
	}
	
	public void addController(AbstractController controller) {
		controllerList.add(controller);
		controllerList.get(controllerList.size() - 1).setView(getView());
	}
	
	public void addSensor(AbstractSensor sensor) {
		sensorList.add(sensor);
	}
	
	public void changeWindObject(String newVal) {
		for(AbstractSensor sensor : sensorList) {
			if(sensor instanceof WindSensor) {
				sensor.setValue(newVal);
			}
		}
	}
	
	public void changeClockObject(String newVal) {
		for(AbstractSensor sensor : sensorList) {
			if(sensor instanceof ClockSensor) {
				sensor.setValue(newVal);
			}
		}
	}
	
	public void changeTempObject(String newVal) {
		for(AbstractSensor sensor : sensorList) {
			if(sensor instanceof TempSensor) {
				sensor.setValue(newVal);
			}
		}
	}
	
	public void openDoor() {
		for(AbstractSensor sensor : sensorList) {
			if(sensor instanceof DoorLock) {
				sensor.setValue(null);
			}
		}
	}
}
