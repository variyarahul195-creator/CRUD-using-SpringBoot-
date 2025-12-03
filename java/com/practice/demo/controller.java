package com.practice.demo;


import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class controller {

     EmployeeService employeeService;

     public controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //DI(dipendency injection):automatic object creation
    // @Autowired
    // EmployeeService employeeService;
        

    @GetMapping("employees")
    public List<Employee> getAllemployees(){
        
        // Employee emp = new Employee();
        // Employee emp1 = new Employee();
        // employees1.add(null);
        // emp.setName("Rahul");
        // emp.setPhone("8976579128");
        // employees1.add(emp);
        // emp1.setName("Mehul");
        // emp1.setGmail("helloworld@gmail.com");
        // employees1.add(emp1);
        return employeeService.ReadEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getAllemployeesById(@PathVariable Long id){
        return employeeService.ReadEmployee(id);
    }


    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        // employees1.add(employee);
        // return "Saved Succesfully";
        return employeeService.CreateEmployee(employee);
         
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.DeleteEmployee(id))
            return "Deleted successfully";
        return "Not Found";
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
       
        
        return employeeService.UpdateEmployee(id,employee);
    }
    
    
    
}
