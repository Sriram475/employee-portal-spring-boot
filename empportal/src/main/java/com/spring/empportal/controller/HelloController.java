package com.spring.empportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.empportal.model.Employee;
import com.spring.empportal.repo.EmployeeRepo;
import com.spring.empportal.service.EmployeeService;

// @CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloController {

	@Autowired
	EmployeeService employeeService;
	
   // http://localhost:9000/getEmpList
   @GetMapping("/getEmpList")
   List<Employee> getAllEmployeeDetails(){
	   return employeeService.getAllEmployeeDetails();
   }
   
   @GetMapping("/getEmp/{eid}")
   Employee getEmployee(@PathVariable Integer eid){
	 return employeeService.getEmployee(eid);
   }
   
   // http://localhost:9000/createEmp
   @PostMapping("/createEmp")
   Employee createEmployee(@RequestBody Employee employee){
	  return employeeService.createEmployee(employee);
   }
    
   @PutMapping("/updateEmp/{eid}")
   Employee updateEmployee(@RequestBody Employee employee,@PathVariable Integer eid){
	   return employeeService.updateEmployee(employee, eid);
   }
   
   
   
    @DeleteMapping("/delEmp/{eid}")
    String deleteEmployee(@PathVariable Integer eid){
      return employeeService.deleteEmployee(eid);
   }
}
