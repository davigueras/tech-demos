package com.davigueras.h2hibernate01;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "Levi");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from User").list();
		for (User event : (List<User>) result) {
			System.out.println(event.getName());
		}
		session.getTransaction().commit();
		session.close();
	}
	
//	public static void main(String[] a) throws Exception {
//		Class.forName("org.h2.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:h2:database/test", "sa",
//				"");
//
//		Statement st = conn.createStatement();
//		Statement stmt = conn.createStatement();
//		ResultSet rset = stmt.executeQuery("select name from user");
//		while (rset.next()) {
//			String name = rset.getString(1);
//			System.out.println(name);
//		}
//
//		conn.close();
//	}

}
