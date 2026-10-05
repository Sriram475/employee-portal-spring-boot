package com.spring.empportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.empportal.model.Employee;
import com.spring.empportal.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeerepo;

	public List<Employee> getAllEmployeeDetails() {
		return employeerepo.findAll();
	}

	public Employee getEmployee(Integer eid) {
		return employeerepo.findById(eid).orElseThrow();
	}

	public Employee createEmployee(Employee employee) {
		return employeerepo.save(employee);
	}

	public Employee updateEmployee(Employee employee, Integer eid) {

		Employee empFromDb = getEmployee(eid);

		empFromDb.setAge(employee.getAge());
		empFromDb.setCity(employee.getCity());
		empFromDb.setEname(employee.getEname());
		empFromDb.setSalary(employee.getSalary());
		empFromDb.setState(employee.getState());

		return employeerepo.save(empFromDb);
	}

	public String deleteEmployee(Integer eid) {
		employeerepo.deleteById(eid);
		return "Employee has been deleted successfully with id of !!" + eid;
	}
}
