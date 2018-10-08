import id.ac.sgu.SmartHome.AbstractClasses.AbstractSensor;
import id.ac.sgu.SmartHome.Controller.MainController;
import id.ac.sgu.SmartHome.ModelClasses.Aircond;
import id.ac.sgu.SmartHome.ModelClasses.TempSensor;
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
		controller.addView(view);
		
		Scene scene = new Scene(view, 960, 480);
        primaryStage.setTitle("Agro Smart Home");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
