package day15.jpav1;

import java.util.Scanner;

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
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Your Choice");
		System.out.println("1. Create");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		
		
		
		
		scanner.close();
	}
	
	
	public static void deleteRecord() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager =  factory.createEntityManager();
		
		
		// find
		Employee employee =  entityManager.find(Employee.class, 6);
		
		// delete
		entityManager.getTransaction().begin();
		entityManager.remove(employee); // delete operation happpening
		entityManager.getTransaction().commit();
	}
	
	
	public static void udpateRecord() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager =  factory.createEntityManager();
		
		// User requirment, want to update rerocd haivng id 6
		Employee employee =  entityManager.find(Employee.class, 4);
		
		// which you column/ properties you want to update
		// employee.setEmail("ravikant@gmail.com");
		// employee.setMobile("9191919191");
		employee.setSalary(10000.0);
		
		
		// update
		entityManager.getTransaction().begin();
		entityManager.merge(employee);
		entityManager.getTransaction().commit();
	}
	
	
	public static void readRecord() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager =  factory.createEntityManager();
		
		Employee emp = entityManager.find(Employee.class, 1);
		System.out.println(emp);
	}
	

	public static void createRecord() {
		// 1.  :: factiory is the database info :: Externalied the database info
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
