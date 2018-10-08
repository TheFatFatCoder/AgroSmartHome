package id.ac.sgu.SmartHome.View;

import id.ac.sgu.SmartHome.Controller.MainController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.scene.shape.Circle;

//@SuppressWarnings({ "restriction", "unused" })
public class MainView extends StackPane {
	
	MainController controller;
	Text airconStateText = new Text("-");
	Text blindsStateText = new Text("-");
	Text alarmStateText = new Text("-");
	Text lightsStateText = new Text("-");
	TextField tempField = new TextField("0");
	TextField windField = new TextField("0");
	TextField clockField = new TextField("00:00:00");
	
	public MainView(MainController controller) {
		this.controller = controller;
		
		VBox mainAndInput = new VBox();
		mainAndInput.setStyle("-fx-background-color: #f00;");
		
		HBox actorsMonitor = new HBox();
		actorsMonitor.setStyle("-fx-alignment: center; -fx-height: 860px; "
				+ "-fx-background-color: #f5f5f5; -fx-padding: 15px; -fx-spacing: 50px");
		
		Text airconText = new Text("AC");
		airconText.setStyle("-fx-font-size: 36pt");
		airconStateText.setStyle("-fx-font-size: 18pt");
		VBox airconBox = new VBox();
		airconBox.setStyle("-fx-alignment: center");
		airconBox.getChildren().addAll(airconText, airconStateText);
		
		Text blindsText = new Text("Blinds");
		blindsText.setStyle("-fx-font-size: 36pt");
		blindsStateText.setStyle("-fx-font-size: 18pt");
		VBox blindsBox = new VBox();
		blindsBox.setStyle("-fx-alignment: center");
		blindsBox.getChildren().addAll(blindsText, blindsStateText);
		
		Text alarmText = new Text("Alarm");
		alarmText.setStyle("-fx-font-size: 36pt");
		alarmStateText.setStyle("-fx-font-size: 18pt");
		VBox alarmBox = new VBox();
		alarmBox.setStyle("-fx-alignment: center");
		alarmBox.getChildren().addAll(alarmText, alarmStateText);
		
		Text lightsText = new Text("Lights");
		lightsText.setStyle("-fx-font-size: 36pt");
		lightsStateText.setStyle("-fx-font-size: 18pt");
		VBox lightsBox = new VBox();
		lightsBox.setStyle("-fx-alignment: center");
		lightsBox.getChildren().addAll(lightsText, lightsStateText);
		
		actorsMonitor.getChildren().addAll(airconBox, blindsBox, alarmBox, lightsBox);
		
		HBox inputsBox = new HBox();
		inputsBox.setStyle("-fx-background-color: #e1e1e1; -fx-padding: 5px; -fx-spacing: 40px; "
				+ "-fx-alignment: center;");
		
		HBox tempBox = new HBox();
		tempBox.setStyle("-fx-alignment: center; -fx-spacing: 5px");
		Label tempLabel = new Label("Temperature");
		tempField.setStyle("-fx-pref-width: 50px;");
		Label tempUnitLabel = new Label("Celcius");
		tempBox.getChildren().addAll(tempLabel, tempField, tempUnitLabel);
		
		HBox windBox = new HBox();
		windBox.setStyle("-fx-alignment: center; -fx-spacing: 5px");
		Label windLabel = new Label("Wind Speed");
		windField.setStyle("-fx-pref-width: 50px;");
		Label windUnitLabel = new Label("Knots");
		windBox.getChildren().addAll(windLabel, windField, windUnitLabel);
		
		HBox clockBox = new HBox();
		clockBox.setStyle("-fx-alignment: center; -fx-spacing: 5px");
		Label clockLabel = new Label("Clock");
		clockField.setStyle("-fx-pref-width: 80px;");
		clockBox.getChildren().addAll(clockLabel, clockField);
		
		inputsBox.getChildren().addAll(tempBox, windBox, clockBox);
		
		mainAndInput.getChildren().addAll(actorsMonitor, inputsBox);
		VBox.setVgrow(actorsMonitor, Priority.ALWAYS);
		VBox.setVgrow(inputsBox, Priority.SOMETIMES);
		
		this.getChildren().add(mainAndInput);
		
		setListeners();
    }
	
	public void setListeners() {
		tempField.textProperty().addListener((observable, oldVal, newVal) -> {
			
		});
		windField.textProperty().addListener((observable, oldValue, newVal) -> {
			controller.changeWindObject(newVal);
		});
		clockField.textProperty().addListener((observable, oldVal, newVal) -> {
			
		}); 
	}
	
	public void turnOnAircon(boolean state) {
		if(state) {
			airconStateText.setText("ON");
			airconStateText.setStyle("-fx-font-size: 18pt; -fx-fill: #138227");
		} else {
			airconStateText.setText("OFF");
			airconStateText.setStyle("-fx-font-size: 18pt; -fx-fill: #c8c8c8");
		}
	}
	
	public void turnOnBlinds(boolean state) {
		if(state) {
			blindsStateText.setText("ON");
			blindsStateText.setStyle("-fx-font-size: 18pt; -fx-fill: #138227");
		} else {
			blindsStateText.setText("OFF");
			blindsStateText.setStyle("-fx-font-size: 18pt; -fx-fill: #c8c8c8");
		}
	}
	
	public void turnOnAlarm(boolean state) {
		if(state) {
			alarmStateText.setText("ON");
			alarmStateText.setStyle("-fx-font-size: 18pt; -fx-fill: #138227");
		} else {
			alarmStateText.setText("OFF");
			alarmStateText.setStyle("-fx-font-size: 18pt; -fx-fill: #c8c8c8");
		}
	}
	
	public void turnOnLights(boolean state) {
		if(state) {
			lightsStateText.setText("ON");
			lightsStateText.setStyle("-fx-font-size: 18pt; -fx-fill: #138227");
		} else {
			lightsStateText.setText("OFF");
			lightsStateText.setStyle("-fx-font-size: 18pt; -fx-fill: #c8c8c8");
		}
	}
}
