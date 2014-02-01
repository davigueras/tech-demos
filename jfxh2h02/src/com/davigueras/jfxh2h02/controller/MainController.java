package com.davigueras.jfxh2h02.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

import com.davigueras.jfxh2h02.model.Author;
import com.davigueras.jfxh2h02.model.Book;
import com.davigueras.jfxh2h02.model.Publisher;

public class MainController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    
    @FXML
    private ListView<String> listView;
    
    @FXML
    private TableColumn<Book, String> bookAuthor;
    @FXML
    private TableColumn<Book, String> bookGenre;
    @FXML
    private TableColumn<Book, Integer> bookId;
    @FXML
    private TableColumn<Book, String> bookPublisher;
    @FXML
    private TableColumn<Book, String> bookTitle;
    @FXML
    private TableView<Book> bookTableView;
    
    @FXML
    private TableColumn<Author, String> authorName;
    @FXML
    private TableColumn<Author, String> authorCountry;
    @FXML
    private TableColumn<Author, Integer> authorId;
    @FXML
    private TableView<Author> authorTableView;
    
    @FXML
    private TableColumn<Publisher, String> publisherName;
    @FXML
    private TableColumn<Publisher, String> publisherCity;
    @FXML
    private TableColumn<Publisher, Integer> publisherId;
    @FXML
    private TableView<Publisher> publisherTableView;
    
    // Other members
    
  	ObservableList<String> menu = FXCollections.observableArrayList("Libros", "Autores", "Editoriales", "Informes");
  	
  	ObservableList<Book> booksData = FXCollections.observableArrayList();
  	ObservableList<Author> authorsData = FXCollections.observableArrayList();
  	ObservableList<Publisher> publishersData = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
    	
    	loadTestData();
    	
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
    	
    	bookTableView.setItems(booksData);	
		bookId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
		bookTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));

		/* este snippet es super importante ya que permite cargar propiedades de un objeto miembro del objeto
		 * del objeto cuyo registro estamos mostrando. Me ha costado bastante averiguar la forma en que 
		 * esto funciona.
		 * Parece ser setcellvaluefactory quiere un objeto propertyvaluefactory con nuestros parametros,
		 * pero pero si hacemos un override mediante callback no sirve retornar un string, en la medida
		 * que es javafx quiere que retornemos un simple<tipo>property. 
		 * ni cambiar el tipo en el objeto ni el tipo del retorno en el override servian de nada */
		
		bookAuthor.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {  
		     @Override  
		     public ObservableValue<String> call(CellDataFeatures<Book, String> data) {  
		          return new SimpleStringProperty(data.getValue().getAuthor().getName());  
		     }  
		});  
		
		/* mas de lo mismo */
		
		bookPublisher.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
		bookPublisher.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {  
		     @Override  
		     public ObservableValue<String> call(CellDataFeatures<Book, String> data) {  
		          return new SimpleStringProperty(data.getValue().getPublisher().getName());  
		     }  
		});  
		
		bookGenre.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));

    	authorTableView.setItems(authorsData);	
		authorId.setCellValueFactory(new PropertyValueFactory<Author, Integer>("id"));
		authorName.setCellValueFactory(new PropertyValueFactory<Author, String>("name"));
		authorCountry.setCellValueFactory(new PropertyValueFactory<Author, String>("country"));
		
    	publisherTableView.setItems(publishersData);	
		publisherId.setCellValueFactory(new PropertyValueFactory<Publisher, Integer>("id"));
		publisherName.setCellValueFactory(new PropertyValueFactory<Publisher, String>("name"));
		publisherCity.setCellValueFactory(new PropertyValueFactory<Publisher, String>("city"));

    }

	private void loadTestData() {
		Author autor1 = new Author(1, "Sebastien 1", "France");
		Author autor2 = new Author(2, "Grumhilda 2", "Germany");	
		Author autor3 = new Author(3, "Tolkien 3", "UK");
		Author autor4 = new Author(4, "Martin 4", "USA");
		authorsData.add(autor1);		
		authorsData.add(autor2);		
		authorsData.add(autor3);		
		authorsData.add(autor4);		
		
		Publisher publisher1 = new Publisher(1, "Letra capital", "Barcelona");
		Publisher publisher2 = new Publisher(2, "La letra verda", "Madrid");
		Publisher publisher3 = new Publisher(3, "La pluma roja", "Bilbao");
		publishersData.add(publisher1);		
		publishersData.add(publisher2);		
		publishersData.add(publisher3);	
		
		Book book1 = new Book(1, "Libro 1", autor2, publisher3, "Genero A");
		Book book2 = new Book(2, "Libro 2", autor2, publisher2, "Genero A");
		Book book3 = new Book(3, "Libro 3", autor3, publisher3, "Genero B");
		Book book4 = new Book(4, "Libro 4", autor4, publisher3, "Genero B");
		Book book5 = new Book(5, "Libro 5", autor2, publisher1, "Genero C");
		Book book6 = new Book(6, "Libro 6", autor4, publisher1, "Genero C");
		booksData.add(book1);
		booksData.add(book2);
		booksData.add(book3);
		booksData.add(book4);
		booksData.add(book5);
		booksData.add(book6);
		
	}
	
}
