package com.davigueras.h2db01;

import com.davigueras.h2db01.H2Connection;

public class Main {

	public static void main(String[] args) {
		
		/* En primer lugar he descargado el jar de H2 de la pagina web y he creado la libreria de usuario
		 * para incluirlo dentro de mi proyecto.
		 * Luego he ejecutado el jar y se abre un gestor web, la opcion que marque a la entrada es 
		 * embedded y la url da un poco igual porque luego copias y pegas el fichero generado h2.db 
		 * dentro (y incluyes en eclipse) de tu proyecto.
		 * He creado via instrucciones sql el schema y la tabla con los campos.
		 * Luego he a??adido algunos datos para que haya algo. 
		 */
		
		H2Connection connection = new H2Connection();
		connection.test();
	}

}
