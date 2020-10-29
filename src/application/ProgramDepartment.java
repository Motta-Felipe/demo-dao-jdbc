package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class ProgramDepartment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ====");

        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TEST 2: department findAll ====");
        List<Department> departmentList = departmentDao.findAll();
        for (Department dep: departmentList
             ) {
            System.out.println(dep);
        }

        System.out.println("\n=== TEST 3: department Insert ====");
        Department newDepartment = new Department(null, "Clothes");
        departmentDao.insert(newDepartment);
        System.out.println(("Inserted! New id = " + newDepartment.getId()));

        System.out.println("\n=== TEST 4: department Update ====");
        department = departmentDao.findById(9);
        department.setName("Home");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: department Delete ====");
        System.out.println("Enter th id to Delete");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
