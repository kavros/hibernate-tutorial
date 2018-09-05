package com.luv2code.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;


public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory =   new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create a session
		Session session =  factory.getCurrentSession();
		try {
			//create Student Object
			Student tempStuden = new Student("Daffu","Duck","daffy@luv2code.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStuden);
			session.save(tempStuden);
			
			//commit transaction
			Student myStudent = session.get(Student.class,tempStuden.getId());
			System.out.println(myStudent);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
		
	}

}
