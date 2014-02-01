package com.davigueras.jfxh2h02.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController {
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> listView;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @FXML
    private SplitPane splitPane1;

    @FXML
    private SplitPane splitPane2;
    
    // Other members
    
  	ObservableList<String> menu = FXCollections.observableArrayList("Libros", "Autores", "Editoriales", "Informes");
    
    @FXML
    void initialize() {

    	listView.setItems(menu);

    	listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

    		@Override
    	    public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
    			
				pane1.setVisible(false);
				pane2.setVisible(false);
				pane3.setVisible(false);
				pane4.setVisible(false);
    			
    			switch ((String) newValue) {
    			case "Libros":
    				pane1.setVisible(true);
    				break;
    			case "Autores":
    				pane2.setVisible(true);
    				break;
    			case "Editoriales":
    				pane3.setVisible(true);
    				break;
    			case "Informes":
    				pane4.setVisible(true);
    				break;
    			}
    	    }

    	});
    	
    }
	
}
