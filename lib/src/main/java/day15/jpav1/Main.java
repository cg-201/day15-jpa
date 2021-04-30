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
		
		System.out.println("Your Choice --> ");
		int choice = scanner.nextInt();
		switch(choice) {
			case 1:
				createRecord();
				break;
			case 2:
				readRecord();
				break;
			case 3:
				udpateRecord();
				break;
			case 4:
				deleteRecord();
				break;
			default:
				System.out.println("No Match Found!!");
				break;
		}
		
		
		scanner.close();
	}
	
	
	public static void deleteRecord() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager =  factory.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Delete User Id ");
		
		// find
		Employee employee =  entityManager.find(Employee.class, scanner.nextInt());
		
		// delete
		entityManager.getTransaction().begin();
		entityManager.remove(employee); // delete operation happpening
		entityManager.getTransaction().commit();
		
		scanner.close();
	}
	
	
	public static void udpateRecord() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager =  factory.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Update User id : ");
		
		// User requirment, want to update rerocd haivng id 6
		Employee employee =  entityManager.find(Employee.class, scanner.nextInt());
		scanner.nextLine();
		
		// which you column/ properties you want to update
		System.out.println("Enter Email ");
		employee.setEmail(scanner.nextLine());
		
		System.out.println("Enter Mobile");
		employee.setMobile(scanner.nextLine());
		
		System.out.println("Enter Salary");
		employee.setSalary(scanner.nextDouble());
		
		
		// update
		entityManager.getTransaction().begin();
		entityManager.merge(employee);
		entityManager.getTransaction().commit();
		
		scanner.close();
	}
	
	
	public static void readRecord() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager =  factory.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter user id --> ");
		Employee emp = entityManager.find(Employee.class, scanner.nextInt());
		System.out.println(emp);
		
		scanner.close();
	}
	

	public static void createRecord() {
		// 1.  :: factiory is the database info :: Externalied the database info
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager =  factory.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		
		Employee employee = new Employee();
		
		System.out.println("Enter Name");
		employee.setName(scanner.nextLine());
		
		System.out.println("Enter Email");
		employee.setEmail(scanner.nextLine());
		
		System.out.println("Enter Mobile");
		employee.setMobile(scanner.nextLine());
		
		System.out.println("Enter salary");
		employee.setSalary(scanner.nextDouble());
		
		// 2 ?? :: CS / IT
		entityManager.getTransaction().begin();
		
		// 1 Operation :: ideal case is more than 2 or more operation
		// persist / save the object into the database.
		entityManager.persist(employee);
		
		entityManager.getTransaction().commit();
		
		// entityManager.getTransaction().rollback();
		
		scanner.close();
		System.out.println("Employee Added!!");
	}
}
