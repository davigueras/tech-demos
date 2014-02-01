package com.davigueras.jfxh2h02.controller;
	
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/* En esta aplicación voy a intentar desarrollar los siguientes puntos:
 * - Interfaz que permita la visualizacion de distintas capas
 * - Mantenimiento de almenos tres clases
 * - Look up efectivo de otras clases cuando creando una relacionada
 * - Visualizacion condicionada de las otras clases segun seleccion
 *   de un registro concreto de una clase determinada
 * - Generación introductoria y sencilla de informes */

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
