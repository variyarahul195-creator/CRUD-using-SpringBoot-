package com.practice.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private Employee_Repo employee_repo;

    //List<Employee> employees1 = new ArrayList<>();
    public EmployeeServiceImpl(Employee_Repo employee_repo) {
        this.employee_repo = employee_repo;
    }

    @Override
    public String CreateEmployee(Employee employee) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employee_repo.save(employeeEntity);
       //employees1.add(employee);
       return "Saved Succesfully";
    }

    @Override
    public List<Employee> ReadEmployees() {
        List<EmployeeEntity> employeeList = employee_repo.findAll();
        List<Employee> employees1 =new ArrayList<>();

        for (EmployeeEntity EmployeeEntity : employeeList) {
            Employee emp = new Employee();
            emp.setName(EmployeeEntity.getName());
            emp.setGmail(EmployeeEntity.getGmail());
            emp.setId(EmployeeEntity.getId());
            emp.setPhone(EmployeeEntity.getPhone());
            employees1.add(emp);
        }
        return employees1;
    }

    @Override
    public Employee ReadEmployee(Long id) {
        EmployeeEntity empl = employee_repo.findById(id).get();
        Employee employee=new Employee();
        BeanUtils.copyProperties(empl ,employee );
        return employee;
    }

    @Override
    public boolean DeleteEmployee(Long id) {
        EmployeeEntity empdel = employee_repo.findById(id).get();
        employee_repo.delete(empdel);
        return true; 
    }

    @Override
    public String UpdateEmployee(Long id, Employee employee) {
        EmployeeEntity exist_emp = employee_repo.findById(id).get();

        exist_emp.setName(employee.getName());
        exist_emp.setGmail(employee.getGmail());
        exist_emp.setPhone(employee.getPhone());
        employee_repo.save(exist_emp);
       return "Update successfully";
    }

    


    

}
