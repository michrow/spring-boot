package com.example.demo.web.pojo;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmployeeDao {

    @Autowired
    DepartmentDao departmentDao;

    private static List<Employee> employees = new ArrayList<Employee>();
    private static Map<Integer,Employee> employeeHashMap = new HashMap<>();
    public static List<Department> departments = new ArrayList<>();
    public static Map<Integer,Department> departmentMap = new HashMap<>();
    static{
        Department department1 = new Department(RandomUtils.nextInt(),RandomStringUtils.randomAlphabetic(5));
        Department department2 = new Department(RandomUtils.nextInt(),RandomStringUtils.randomAlphabetic(5));
        Department department3 = new Department(RandomUtils.nextInt(),RandomStringUtils.randomAlphabetic(5));
        Department department4 = new Department(RandomUtils.nextInt(),RandomStringUtils.randomAlphabetic(5));
        Department department5 = new Department(RandomUtils.nextInt(),RandomStringUtils.randomAlphabetic(5));
        Department department6 = new Department(RandomUtils.nextInt(),"普元");

        departments.addAll(Arrays.asList(department1,department2,department3,department4,department5,department6));

        for (Department dept:departments
             ) {
            departmentMap.put(dept.getId(),dept);
        }

        Employee employee1 = new Employee(RandomUtils.nextInt(10,100),RandomStringUtils.randomAlphabetic(5),RandomStringUtils.randomAlphabetic(5),RandomUtils.nextInt(0,2),department1,new Date());
        Employee employee2 = new Employee(RandomUtils.nextInt(10,100),RandomStringUtils.randomAlphabetic(5),RandomStringUtils.randomAlphabetic(5),RandomUtils.nextInt(0,2),department2,new Date());
        Employee employee3 = new Employee(RandomUtils.nextInt(10,100),RandomStringUtils.randomAlphabetic(5),RandomStringUtils.randomAlphabetic(5),RandomUtils.nextInt(0,2),department3,new Date());
        Employee employee4 = new Employee(RandomUtils.nextInt(10,100),RandomStringUtils.randomAlphabetic(5),RandomStringUtils.randomAlphabetic(5),RandomUtils.nextInt(0,2),department4,new Date());
        Employee employee5 = new Employee(RandomUtils.nextInt(10,100),RandomStringUtils.randomAlphabetic(5),RandomStringUtils.randomAlphabetic(5),RandomUtils.nextInt(0,2),department5,new Date());
        Employee employee6 = new Employee(5,"王肖辉","wxh@126.com",0,department6,new Date());

        employees.addAll(Arrays.asList(employee1,employee2,employee3,employee4,employee5,employee6));

        for (Employee emp:employees
                ) {
            employeeHashMap.put(emp.getId(),emp);
        }
    }


    public Collection<Employee> getAll() {
        return employees;
    }

    public void add(Employee employee) {
        employee.setId(RandomUtils.nextInt(10,100));
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.add(employee);
    }

    public Employee getEmpById(Integer id) {
        return  employeeHashMap.get(id);
    }

    public void update(Employee employee) {
        Employee old = employeeHashMap.get(employee.getId());
        employees.remove(old);
        employees.add(employee);
        employeeHashMap.put(employee.getId(),employee);

    }

    public void delete(Integer id) {
        employees.remove(employeeHashMap.get(id));
        employeeHashMap.remove(id);
    }
}
