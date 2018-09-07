package com.luv2code.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;


public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =   new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create a session
		
		try {
			Session session =  factory.getCurrentSession();	
			session.beginTransaction();
			//start transaction
			int studentId=2;
			Student mystudent = session.get(Student.class, studentId);
			
			System.out.println("Get complete:"+mystudent);
			
			System.out.println("Updating Student....");
			mystudent.setFirstName("Alex");

			System.out.println("Deleting Student....");
			session.delete(mystudent);

			
			session.getTransaction().commit();
				

			System.out.println("Done");
		}
		finally {
			factory.close();
		}
		
	}

}
