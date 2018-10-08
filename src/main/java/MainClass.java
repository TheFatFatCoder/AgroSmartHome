import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.Controller.BlindsController;
import id.ac.sgu.SmartHome.Controller.MainController;
import id.ac.sgu.SmartHome.ModelClasses.Aircond;
import id.ac.sgu.SmartHome.ModelClasses.Blinds;
import id.ac.sgu.SmartHome.ModelClasses.TempSensor;
import id.ac.sgu.SmartHome.ModelClasses.WindSensor;
import id.ac.sgu.SmartHome.View.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainController controller = new MainController();
		MainView view = new MainView(controller);
		controller.setView(view);
		
		Blinds blinds = new Blinds();
		WindSensor windSensor = new WindSensor();
		BlindsController blindsController = new BlindsController(blinds, windSensor);
		windSensor.addObserver(blindsController);
		controller.addController(blindsController);
		controller.addSensor(windSensor);
		
		Scene scene = new Scene(view, 960, 480);
        primaryStage.setTitle("Agro Smart Home");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
