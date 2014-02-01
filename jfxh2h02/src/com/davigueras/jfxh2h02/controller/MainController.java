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
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;

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
    	
    	// cargamos de bd o datos de prueba
    	
    	if (true) {
    		
    	    List<Book> books = null;
    	    List<Author> authors = null;
    	    List<Publisher> publishers= null;
    	    
    	    Session session = null;
    	    try { 
    			session = HibernateUtil.getSessionFactory().openSession(); 
    			books = session.createQuery("from Book").list(); // Esta query es creada en HQL (hibernate query language)
    			authors = session.createQuery("from Author").list(); // Esta query es creada en HQL (hibernate query language)
    			publishers = session.createQuery("from Publisher").list(); // Esta query es creada en HQL (hibernate query language)
    	    } finally { 
    	        session.close(); 
    	    }  
    	    
    	    authors.iterator();
    	    for (Author author:authors) {
    	    	authorsData.add(author);
    	    }
    	    publishers.iterator();
    	    for (Publisher publisher:publishers) {
    	    	publishersData.add(publisher);
    	    }    	    
    	    books.iterator();
    	    for (Book book:books) {
    	    	booksData.add(book);
    	    }

    	    List<Book> query = authorsData.get(1).getBooks();
    	    query.iterator();
    	    for (Book book:query) {
    	    	System.out.println(book.getTitle());
    	    }

    	} else {
    		loadTestData();
    	}
    	
    	
    	// Capa de datos
    	
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
    	
		// Vistas
		
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

	private void loadTestData() {

		Session session;
		
		Author autor1 = new Author("Sebastien 1", "France");
		Author autor2 = new Author("Grumhilda 2", "Germany");	
		Author autor3 = new Author("Tolkien 3", "UK");
		Author autor4 = new Author("Martin 4", "USA");
		
		Publisher publisher1 = new Publisher("Letra capital", "Barcelona");
		Publisher publisher2 = new Publisher("La letra verda", "Madrid");
		Publisher publisher3 = new Publisher("La pluma roja", "Bilbao");
		
	    session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();  
		
	    session.persist(autor1); 
	    session.persist(autor2); 
	    session.persist(autor3); 
	    session.persist(autor4);
	    
	    session.persist(publisher1); 
	    session.persist(publisher2); 
	    session.persist(publisher3); 
	    
	    session.getTransaction().commit(); 
	    session.close(); 
		
	    Book book1 = new Book("Libro 1", autor2, publisher3, "Genero A");
	    Book book2 = new Book("Libro 2", autor2, publisher2, "Genero A");
	    Book book3 = new Book("Libro 3", autor3, publisher3, "Genero B");		
		Book book4 = new Book("Libro 4", autor4, publisher3, "Genero B");
		Book book5 = new Book("Libro 5", autor2, publisher1, "Genero C");
		Book book6 = new Book("Libro 6", autor4, publisher1, "Genero C");
		
	    session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();  
	    
	    session.persist(book1);
	    session.persist(book2);
	    session.persist(book3);
	    session.persist(book4); 
	    session.persist(book5); 
	    session.persist(book6); 
	    
	    session.getTransaction().commit(); 
	    session.close(); 
	    
		authorsData.add(autor1);		
		authorsData.add(autor2);		
		authorsData.add(autor3);		
		authorsData.add(autor4);
		
		publishersData.add(publisher1);		
		publishersData.add(publisher2);		
		publishersData.add(publisher3);
	    
		booksData.add(book1);
		booksData.add(book2);
		booksData.add(book3);
		booksData.add(book4);
		booksData.add(book5);
		booksData.add(book6);
		
	}
	
}
