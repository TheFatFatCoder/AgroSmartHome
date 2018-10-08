import controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainView;

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
