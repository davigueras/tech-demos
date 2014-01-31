package com.davigueras.javafx02.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane page = (AnchorPane) FXMLLoader.load(Main.class.getResource("MainView.fxml"));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);

			
			
			primaryStage.show();
		} catch(Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
