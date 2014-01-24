package com.davigueras.h2hibernate01.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.davigueras.h2hibernate01.model.Contact;
import com.davigueras.h2hibernate01.model.ContactDAO;

public class Main {

    public static void main(String[] args) { 
        ContactDAO contactDAO = new ContactDAO(); 
        Contact recoveredContact = null;  
        long idToDelete = 0;  

        //Creamos tes instancias de Contacto 
        Contact contact1 = new Contact("Contacto 1", "contacto1@contacto.com", "12345678"); 
        Contact contact2 = new Contact("Contacto 2", "contacto2@contacto.com", "87654321"); 
        Contact contact3 = new Contact("Contacto 3", "contacto3@contacto.com", "45612378");  

        //Guardamos las tres instancias, guardamos el id del contacto1 para usarlo posteriormente 
        idToDelete = contactDAO.saveContact(contact1); 
        contactDAO.saveContact(contact2); 
        contactDAO.saveContact(contact3);  

        //Modificamos el contacto 2 y lo actualizamos 
        contact2.setName("Nuevo Contacto 2"); 
        contactDAO.updateContact(contact2);  

        //Recuperamos el contacto1 de la base de datos 
        recoveredContact = contactDAO.getContact(idToDelete); 
        System.out.println("Recuperamos a " + recoveredContact.getName());  

        //Eliminamos al contactoRecuperado (que es el contacto3) 
        contactDAO.deleteContacto(recoveredContact);  

        //Obtenemos la lista de contactos que quedan en la base de datos y la mostramos 
        List<Contact> contactsList = contactDAO.getContactsList();  
        System.out.println("Hay " + contactsList.size() + "contactos en la base de datos");  

        for (Contact c : contactsList) { 
            System.out.println("-> " + c.getName()); 
        } 
    } 

}
