package id.ac.sgu.SmartHome.Interfaces;

public interface Actuator {
	
	public void doAction(Object action, String arg);
	public Object getState();
}
