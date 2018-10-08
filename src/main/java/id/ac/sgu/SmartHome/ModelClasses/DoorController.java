package id.ac.sgu.SmartHome.ModelClasses;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import id.ac.sgu.SmartHome.AbstractClasses.AbstractActuator;
import id.ac.sgu.SmartHome.AbstractClasses.AbstractController;

public class DoorController extends AbstractController implements Observer{
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	public DoorController(LocalDateTime start, LocalDateTime end) {
		this.startTime = start;
		this.endTime = end;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean timeWithinOnRange(Object param) {
		return endTime.isAfter((LocalDateTime) param) && startTime.isBefore((LocalDateTime) param);
	}

}
