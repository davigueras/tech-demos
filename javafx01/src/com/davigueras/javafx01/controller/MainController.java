package com.davigueras.javafx01.controller;

import com.davigueras.javafx01.model.Product;
import com.davigueras.javafx01.model.Validation;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class MainController {
	
	// Variable
	
	private final ObservableList<Product> tableData = FXCollections.observableArrayList();
	private IntegerProperty index = new SimpleIntegerProperty();
	private IntegerProperty nextId = new SimpleIntegerProperty();
	private StringProperty actionOnCourse = new SimpleStringProperty();
	
	// TableView definitions
	
	@FXML
	private TableView<Product> tableView;
	@FXML
	private TableColumn<Product, Integer> columnId;
	@FXML
	private TableColumn<Product, String> columnRef;
	@FXML
	private TableColumn<Product, String> columnName;
	@FXML
	private TableColumn<Product, String> columnIssueDate; // String por ahora
	@FXML
	private TableColumn<Product, Double> columnCost;
	@FXML
	private TableColumn<Product, Integer> columnProductionMinutes;
	
	// Form field definitions
	
	@FXML
	private HBox hboxSelector;
	@FXML
	private Button buttonNew;
	@FXML
	private Button buttonEdit;
	@FXML
	private Button buttonDelete;	
	
	@FXML
	private HBox hboxFields;
	@FXML
	private TextField fieldRef;
	@FXML
	private TextField fieldName;
	@FXML
	private TextField fieldIssueDate;
	@FXML
	private TextField fieldCost;
	@FXML
	private TextField fieldProductionMinutes;
	@FXML
	private HBox hboxSave;
	@FXML
	private Button buttonCancel;
	@FXML
	private Button buttonAccept;
	@FXML
	private Label labelError;
	
	// Events
	
	@FXML
	void startAction(ActionEvent event) {
		this.actionOnCourse.set(((Button) event.getSource()).getId());
		switch (this.actionOnCourse.get()) {
		case "buttonNew":
			startNewAction();
			break;
		case "buttonEdit":
			startEditAction();
			break;
		case "buttonDelete":
			startDeleteAction();
			break;
		}
	}
	@FXML
	void cancelAction(ActionEvent event) {
		endAction();
		labelError.getStyleClass().remove("red");
		labelError.getStyleClass().remove("yellow");
		labelError.getStyleClass().remove("green");
		fieldRef.getStyleClass().remove("error");	
		fieldRef.getStyleClass().remove("ok");
		fieldName.getStyleClass().remove("error");	
		fieldName.getStyleClass().remove("ok");
		fieldIssueDate.getStyleClass().remove("error");	
		fieldIssueDate.getStyleClass().remove("ok");
		fieldCost.getStyleClass().remove("error");	
		fieldCost.getStyleClass().remove("ok");
		fieldProductionMinutes.getStyleClass().remove("error");	
		fieldProductionMinutes.getStyleClass().remove("ok");
		labelError.setText("Acci??n cancelada.");			
		System.out.println("Action canceled.");
	}	
	@FXML
	void performAction(ActionEvent event) {
		boolean validProductionMinutes = false;		
		boolean validCost = false;
		boolean validIssueDate = false;
		boolean validName = false;
		boolean validRef = false;
		
		labelError.getStyleClass().remove("yellow");
		
		switch (actionOnCourse.get()) {
		case "new":
			//estan en orden inverso para que, dado que se comprueban todos, aparezcan en ordn correcto
			validProductionMinutes = Validation.textFieldNotEmpty(fieldProductionMinutes, labelError, "El campo es obligatorio.") 
					&& Validation.textFieldIsInteger(fieldProductionMinutes, labelError, "El valor introducido no es un n??mero entero v??lido.");			
			validCost = Validation.textFieldNotEmpty(fieldCost, labelError, "El campo es obligatorio.") 
					&& Validation.textFieldIsDouble(fieldCost, labelError, "El valor introducido no es un n??mero decimal v??lido.");			
			// o hace falta decir que en caso de la fecha va a hacer falta mucha chicha para verificar que la fecha es buena
			// desentra??ar el misterio de si Date o Calendar y entender que es mejor...
			validIssueDate = Validation.textFieldNotEmpty(fieldIssueDate, labelError, "El campo es obligatorio.");	
			validName = Validation.textFieldNotEmpty(fieldName, labelError, "El campo es obligatorio.");			
			validRef = Validation.textFieldNotEmpty(fieldRef, labelError, "El campo es obligatorio.")
					&& Validation.textFieldOnlyAlphaNumeric(fieldRef, labelError, "Solo se permiten car??cteres alfanum??ricos.");			

			if (validRef && validName && validIssueDate && validCost && validProductionMinutes) {
				fieldRef.getStyleClass().remove("error");	
				fieldRef.getStyleClass().remove("ok");
				fieldName.getStyleClass().remove("error");	
				fieldName.getStyleClass().remove("ok");
				fieldIssueDate.getStyleClass().remove("error");	
				fieldIssueDate.getStyleClass().remove("ok");
				fieldCost.getStyleClass().remove("error");	
				fieldCost.getStyleClass().remove("ok");
				fieldProductionMinutes.getStyleClass().remove("error");	
				fieldProductionMinutes.getStyleClass().remove("ok");
				Product addedProduct = new Product(
						nextId.get(), 
						fieldRef.getText(),
						fieldName.getText(),
						fieldIssueDate.getText(),
						Double.valueOf(fieldCost.getText()),
						Integer.valueOf(fieldProductionMinutes.getText())
						);
				nextId.set(nextId.get() + 1);
				tableData.add(addedProduct);
	    		labelError.getStyleClass().add("green");
				labelError.setText("El Producto ha sido creado correctamente.");
				System.out.println("Product Id " + addedProduct.getId() + " created.");
				endAction();
			} else {
	    		labelError.getStyleClass().add("red");
				System.out.println("Validation issues occurred.");
			}
			break;
		case "edit":
			//estan en orden inverso para que, dado que se comprueban todos, aparezcan en ordn correcto
			validProductionMinutes = Validation.textFieldNotEmpty(fieldProductionMinutes, labelError, "El campo es obligatorio.") 
					&& Validation.textFieldIsInteger(fieldProductionMinutes, labelError, "El valor introducido no es un n??mero entero v??lido.");			
			validCost = Validation.textFieldNotEmpty(fieldCost, labelError, "El campo es obligatorio.") 
					&& Validation.textFieldIsDouble(fieldCost, labelError, "El valor introducido no es un n??mero decimal v??lido.");			
			// o hace falta decir que en caso de la fecha va a hacer falta mucha chicha para verificar que la fecha es buena
			// desentra??ar el misterio de si Date o Calendar y entender que es mejor...
			validIssueDate = Validation.textFieldNotEmpty(fieldIssueDate, labelError, "El campo es obligatorio.");	
			validName = Validation.textFieldNotEmpty(fieldName, labelError, "El campo es obligatorio.");			
			validRef = Validation.textFieldNotEmpty(fieldRef, labelError, "El campo es obligatorio.")
					&& Validation.textFieldOnlyAlphaNumeric(fieldRef, labelError, "Solo se permiten car??cteres alfanum??ricos.");		
			
			if (validRef && validName && validIssueDate && validCost && validProductionMinutes) {
				fieldRef.getStyleClass().remove("error");	
				fieldRef.getStyleClass().remove("ok");
				fieldName.getStyleClass().remove("error");	
				fieldName.getStyleClass().remove("ok");
				fieldIssueDate.getStyleClass().remove("error");	
				fieldIssueDate.getStyleClass().remove("ok");
				fieldCost.getStyleClass().remove("error");	
				fieldCost.getStyleClass().remove("ok");
				fieldProductionMinutes.getStyleClass().remove("error");	
				fieldProductionMinutes.getStyleClass().remove("ok");
				Product modifiedProduct = tableData.get(index.get());
				modifiedProduct.setRef(fieldRef.getText());
				modifiedProduct.setName(fieldName.getText());
				modifiedProduct.setIssueDate(fieldIssueDate.getText());
				modifiedProduct.setCost(Double.valueOf(fieldCost.getText()));
				modifiedProduct.setProductionMinutes(Integer.valueOf(fieldProductionMinutes.getText()));
	    		labelError.getStyleClass().add("green");
				labelError.setText("El Producto ha sido modificado correctamente.");
	    		System.out.println("Product Id " + modifiedProduct.getId() + " updated.");
				updateTableViewWorkaround();
				endAction();
			} else {
	    		labelError.getStyleClass().add("red");
				System.out.println("Validation issues occurred.");
			}
			break;
		case "delete":
			int id = tableData.get(index.get()).getId();
    		tableData.remove(index.get());
    		labelError.getStyleClass().add("green");
    		labelError.setText("El Producto ha sido eliminado correctamente.");
    		System.out.println("Product Id " + id + " deleted.");
    		endAction();
			break;
		}
	}

	// Initialization
	
	@FXML
	private void initialize() {
		index.set(-1);
		nextId.set(1);
		
		columnId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
		columnRef.setCellValueFactory(new PropertyValueFactory<Product, String>("ref"));
		columnName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		columnIssueDate.setCellValueFactory(new PropertyValueFactory<Product, String>("issueDate"));
		columnCost.setCellValueFactory(new PropertyValueFactory<Product, Double>("cost"));
		columnProductionMinutes.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productionMinutes"));
		tableView.setItems(tableData);
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
				index.set(tableData.indexOf(newValue));
				System.out.println("Row index " + index.get() + " selected.");
				if (index.get() > -1) {
					disableOptionButtons(false);
					disableActionButtons(true);
					actionOnCourse.set("");
					hboxFields.disableProperty().set(true);
					refillFieldsFromSelection(tableData.get(index.get()));
					
				} else {
					disableOptionButtons(true);
					clearFields();
				}
				labelError.setText("");
				labelError.getStyleClass().remove("red");
				labelError.getStyleClass().remove("yellow");
				labelError.getStyleClass().remove("green");
				fieldRef.getStyleClass().remove("error");	
				fieldRef.getStyleClass().remove("ok");
				fieldName.getStyleClass().remove("error");	
				fieldName.getStyleClass().remove("ok");
				fieldIssueDate.getStyleClass().remove("error");	
				fieldIssueDate.getStyleClass().remove("ok");
				fieldCost.getStyleClass().remove("error");	
				fieldCost.getStyleClass().remove("ok");
				fieldProductionMinutes.getStyleClass().remove("error");	
				fieldProductionMinutes.getStyleClass().remove("ok");
			}
		});
		
	}
	
	// Methods
	
	private void clearFields() {
		fieldRef.clear();
		fieldName.clear();
		fieldIssueDate.clear();
		fieldCost.clear();
		fieldProductionMinutes.clear();
	}
	
	private void refillFieldsFromSelection(Product product) {
		fieldRef.setText(product.getRef());
		fieldName.setText(product.getName());
		fieldIssueDate.setText(product.getIssueDate());
		fieldCost.setText(String.valueOf(product.getCost()));
		fieldProductionMinutes.setText(String.valueOf(product.getProductionMinutes()));
	}
	
	private void disableOptionButtons(boolean disable) {
		buttonEdit.disableProperty().set(disable);
		buttonDelete.disableProperty().set(disable);		
	}
	
	private void disableActionButtons(boolean disable) {
		buttonCancel.disableProperty().set(disable);
		buttonAccept.disableProperty().set(disable);		
	}
	

	private void startNewAction() {
		actionOnCourse.set("new");
		tableView.getSelectionModel().clearSelection();
		hboxFields.disableProperty().set(false);
		disableActionButtons(false);
		fieldRef.requestFocus();
		System.out.println("Starting addition.");
	}
	
	private void startEditAction() {
		actionOnCourse.set("edit");
		hboxFields.disableProperty().set(false);
		disableActionButtons(false);
		fieldRef.requestFocus();
		System.out.println("Starting edition.");
	}
	
	private void startDeleteAction() {
		actionOnCourse.set("delete");
		hboxFields.disableProperty().set(false);
		disableActionButtons(false);
		buttonCancel.requestFocus();
		labelError.getStyleClass().add("yellow");
		labelError.setText("??Desea eliminar el producto seleccionado?");
		System.out.println("Starting deletion.");		
	}
	
	/**
	 * <p>Actualizaci??n del contenido de la tableView para que muestre los datos de tableData.</p>
	 * <p>En principio esto sucede automaticamente ante las acciones add y remove sobre tableData.
	 * Pero como al actualizar el producto dentro de tableData no se modifica nada de tableData propiamente dicho
	 * creo que el listener no puede saber que ha habido un cambio. Con este hack conseguimos
	 * que se actualize sin aparentes inconveniencias.</p>
	 */
	private void updateTableViewWorkaround() {
		columnRef.setVisible(!columnRef.isVisible());
		columnRef.setVisible(!columnRef.isVisible());
	}
	
	/**
	 * <p>Instrucciones comenues al cierre de cualquier operacion. Estas son:</p>
	 * <ol>
	 * <li>Limpiar la variable de accion en curso</li>
	 * <li>Limpiar y desactivar linea de campos</li>
	 * <li>Desactivar botones de guardado</li>
	 * <li>Reenfocar en la tabla pero sin registro seleccionado</li>
	 * </ol>
	 */
	private void endAction() {
		actionOnCourse.set("");
		clearFields();
		hboxFields.disableProperty().set(true);
		disableActionButtons(true);
		tableView.getSelectionModel().clearSelection();  
		tableView.requestFocus();
		System.out.println("Action ended.");
	}
}
