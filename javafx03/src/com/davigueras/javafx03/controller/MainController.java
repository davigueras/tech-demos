package com.davigueras.javafx03.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane scrollPane1;

    @FXML
    private ScrollPane scrollPane2;

    @FXML
    private TreeView<String> treeView1 = new TreeView<String>();

    @FXML
    private TreeView<String> treeView2 = new TreeView<String>();;
	    
    @FXML
    void initialize() {

    	TreeItem<String> tree1 = new TreeItem<String>("Root 1");
     	TreeItem<String> tree11 = new TreeItem<String>("Leaf 1.1");
     	TreeItem<String> tree12 = new TreeItem<String>("Leaf 1.2");
    	TreeItem<String> tree2 = new TreeItem<String>("Root 2");
     	TreeItem<String> tree21 = new TreeItem<String>("Leaf 2.1");
     	TreeItem<String> tree22 = new TreeItem<String>("Leaf 2.2");
    	
     	tree1.setExpanded(true);
     	tree2.setExpanded(true);
     	tree1.getChildren().add(tree11);
     	tree1.getChildren().add(tree12);
     	tree2.getChildren().add(tree21);
     	tree2.getChildren().add(tree22);

	    treeView1.setRoot(tree1);
	    treeView2.setRoot(tree2);
	    	
	    treeView1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
				evaluateTreeSelection(newValue);
			}
		});
	    
	    treeView2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
				evaluateTreeSelection(newValue);
			}
		});
    }		
    
    private void evaluateTreeSelection(Object newValue) {
		TreeItem<String> selectedItem = (TreeItem<String>) newValue;

		System.out.println(selectedItem.getValue());
		
		switch (selectedItem.getValue()) {
		case "Root 1":
		case "Leaf 1.1":
		case "Leaf 1.2":
			scrollPane1.setVisible(true);
			scrollPane2.setVisible(false);
			break;
		case "Root 2":
		case "Leaf 2.1":
		case "Leaf 2.2":
			scrollPane1.setVisible(false);
			scrollPane2.setVisible(true);
			break;
		}
	}
}
