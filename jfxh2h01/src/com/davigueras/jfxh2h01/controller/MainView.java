package com.davigueras.jfxh2h01.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MainView extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane page = (AnchorPane) FXMLLoader.load(MainView.class.getResource("MainController.fxml"));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

