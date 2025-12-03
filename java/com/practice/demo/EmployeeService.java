package com.practice.demo;

import java.util.List;




public interface EmployeeService {

    String CreateEmployee(Employee employee);
    List<Employee> ReadEmployees();
    Employee ReadEmployee(Long id);
    boolean DeleteEmployee(Long id);
    String UpdateEmployee(Long id, Employee employee);
    

}
