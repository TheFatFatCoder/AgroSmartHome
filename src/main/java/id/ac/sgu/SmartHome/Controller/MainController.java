package id.ac.sgu.SmartHome.Controller;

import java.util.List;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.ModelClasses.WindSensor;
import id.ac.sgu.SmartHome.View.MainView;

public class MainController extends AbstractController {
	
	private List<AbstractController> controllerList;
	private List<AbstractSensor> sensorList;
	
	public void addController(AbstractController controller) {
		this.controllerList.add(controller);
	}
	
	public void addSensor(AbstractSensor sensor) {
		this.sensorList.add(sensor);
	}
	
	public void changeWindObject(String newVal) {
		WindSensor windSensor = (WindSensor) sensorList.stream().
				filter(BlindsController.class::isInstance);
		if(windSensor == null) {
			System.out.println("null shit");
		}
		windSensor.setValue(newVal);
	}
}
