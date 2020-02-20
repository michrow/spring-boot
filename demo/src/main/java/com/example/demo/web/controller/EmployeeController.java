package com.example.demo.web.controller;

import com.example.demo.web.pojo.Department;
import com.example.demo.web.pojo.DepartmentDao;
import com.example.demo.web.pojo.Employee;
import com.example.demo.web.pojo.EmployeeDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 获取员工列表
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 跳转至员工添加页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getAll();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 添加员工列表
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String add(Employee employee){
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    /**
     * 跳转至员工编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.getEmpById(id);
        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getAll();
        model.addAttribute("depts",departments);

        return "/emp/add";
    }

    /**
     * 更新员工
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.update(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public  String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}

