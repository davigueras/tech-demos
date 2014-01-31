package com.davigueras.javafx02.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;


public class MainController {
	
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TreeView<String> treeView = new TreeView<String>();
	    
	    @FXML
	    private Label label1;
	    
	    @FXML
	    private Label label2;
	    
	    @FXML
	    private Pane sp1;
	    
	    @FXML
	    private Pane sp2;
	    
	    @FXML
	    void initialize() {

	    	TreeItem<String> treeRoot = new TreeItem<String>("Root Node");
   	     	TreeItem<String> treeItem1 = new TreeItem<String>("Item 1");
   	     	TreeItem<String> treeItem2 = new TreeItem<String>("Item 2");
	    	
   	     	treeRoot.setExpanded(true);
   	     	treeRoot.getChildren().add(treeItem1);
   	     	treeRoot.getChildren().add(treeItem2);
	    	 
   	     	treeView.setRoot(treeRoot);
	    	
   	     	
 
   	     	
   	     	
   	     	treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
   	     		
   				public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
   					
   					TreeItem<String> selectedItem = (TreeItem<String>) newValue;

   					if (selectedItem.getValue().compareTo("Item 1") == 0) {
   						sp1.setVisible(true);
						sp2.setVisible(false);
   					} else {
   						sp2.setVisible(true);
						sp1.setVisible(false);
   					}
   				}
   			});
	    }
	}
