package com.example.demo.web.pojo;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DepartmentDao {

    public Collection<Department> getAll() {
        return EmployeeDao.departments;
    }

    public Department getDepartmentById(Integer id){
        return  EmployeeDao.departmentMap.get(id);
    }

}
