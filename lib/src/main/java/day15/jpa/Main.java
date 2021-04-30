package day15.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// CRUD :: CREATE, READ, UPDATE, DLETE, READ_ALL
// Non Entity Class
// Verb Class
// Action Class.
// these clasess helps to perform oprations with entity.
public class Main {
	
	public static void main(String[] args) {
		// 1. ?? :: factiory is the database info :: Externalied the database info
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager =  factory.createEntityManager();
		
		
		Employee employee = new Employee();
		employee.setName("Rohit");
		employee.setEmail("rohit@gmail.com");
		employee.setMobile("12112121");
		employee.setSalary(10000);
		
		// 2 ?? :: CS / IT
		entityManager.getTransaction().begin();
		
		// 1 Operation :: ideal case is more than 2 or more operation
		// persist / save the object into the database.
		entityManager.persist(employee);
		
		entityManager.getTransaction().commit();
		
		// entityManager.getTransaction().rollback();
		
		System.out.println("Employee Added!!");
	}
}
