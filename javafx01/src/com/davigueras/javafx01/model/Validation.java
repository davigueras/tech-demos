package com.davigueras.javafx01.model;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Validation {
	
	public static boolean textFieldNotEmpty(TextField textField) {
		boolean valid = false;
		if (textField.getText() != null && !textField.getText().isEmpty()) {
			valid = true;
		}
		return valid;
	}
	
	public static boolean textFieldNotEmpty(TextField textField, Label label, String message) {
		boolean valid = false;
		textField.getStyleClass().remove("error");
		textField.getStyleClass().remove("ok");
		if (!textFieldNotEmpty(textField)) {
			label.setText(message);
			textField.getStyleClass().add("error");
			textField.requestFocus();
		} else {
			textField.getStyleClass().add("ok");
			valid = true;
		}
		return valid;
	}
	
	public static boolean textFieldOnlyAlphaNumeric(TextField textField) {
		boolean valid = false;
		
		// per ara tot es valid
		valid = true;
		
		return valid;
	}
	
	public static boolean textFieldOnlyAlphaNumeric(TextField textField, Label label, String message) {
		boolean valid = false;
		textField.getStyleClass().remove("error");
		textField.getStyleClass().remove("ok");
		if (!textFieldOnlyAlphaNumeric(textField)) {
			label.setText(message);
			textField.getStyleClass().add("error");
			textField.requestFocus();
		} else {
			textField.getStyleClass().add("ok");
			valid = true;
		}
		return valid;
	}
	
	public static boolean textFieldIsDouble(TextField textField) {
		boolean valid = false;
		try {
			Double.parseDouble(textField.getText());
			valid = true;			
		} catch (NumberFormatException e) {
			valid = false;
		}
		return valid;
	}
	
	public static boolean textFieldIsDouble(TextField textField, Label label, String message) {
		
		// a todo esto habra que asegurarse que los decimales funcionan segun la configuracion regional espa??????ola
		// no hace falta que sea dinamico, simplemente que sea la que nos conviene
		
		boolean valid = false;
		textField.getStyleClass().remove("error");
		textField.getStyleClass().remove("ok");
		if (!textFieldIsDouble(textField)) {
			label.setText(message);
			textField.getStyleClass().add("error");
			textField.requestFocus();
		} else {
			textField.getStyleClass().add("ok");
			valid = true;
		}
		return valid;
	}
	
	public static boolean textFieldIsInteger(TextField textField) {
		boolean valid = false;
		try {
			Integer.parseInt(textField.getText());
			valid = true;			
		} catch (NumberFormatException e) {
			valid = false;
		}
		return valid;
	}
	
	public static boolean textFieldIsInteger(TextField textField, Label label, String message) {
		boolean valid = false;
		textField.getStyleClass().remove("error");
		textField.getStyleClass().remove("ok");
		if (!textFieldIsInteger(textField)) {
			label.setText(message);
			textField.getStyleClass().add("error");
			textField.requestFocus();
		} else {
			textField.getStyleClass().add("ok");
			valid = true;
		}
		return valid;
	}
	
}
