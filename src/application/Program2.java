package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1 : findById ====");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println("\n==== TEST 2 : findAll ====");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("==== TEST 3 : deleteById ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted");
		
		System.out.println("\n==== TEST 4 : update ====");
		dep = departmentDao.findById(1);
		dep.setName("Computer");
		departmentDao.update(dep);
		System.out.println("Update Completed!");
		
		System.out.println("\n==== TEST 5 : insert ====");
		dep = new Department(null, "Makeup");
		departmentDao.insert(dep);
		System.out.println("Completed!");
		
		sc.close();
	}

}
