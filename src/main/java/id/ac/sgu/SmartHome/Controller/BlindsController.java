package id.ac.sgu.SmartHome.Controller;

import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;
import id.ac.sgu.SmartHome.ModelClasses.Blinds;
import id.ac.sgu.SmartHome.View.MainView;

public class BlindsController extends AbstractController implements Observer {
	
	private Blinds blinds;
	
	public BlindsController(Blinds blinds) {
		this.blinds = blinds;
		this.setView(super.getView());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		blinds.doAction(null, "asdf");
		view.turnOnBlinds(true);
	}
}
