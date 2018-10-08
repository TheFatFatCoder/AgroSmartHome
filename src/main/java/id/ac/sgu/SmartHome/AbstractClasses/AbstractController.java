package id.ac.sgu.SmartHome.AbstractClasses;

import id.ac.sgu.SmartHome.View.MainView;

public abstract class AbstractController {
	
	protected MainView view;
	
	public MainView getView() {
		return this.view;
	}
	
	public void setView(MainView view) {
		this.view = view;
	}
}
