package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repo.DepartmentRepository;
import com.example.demo.repo.EmployeeRepository;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/home")
   public void home(){
    System.out.println("Hello World");
    }
    @PostMapping("emp")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee = employeeRepository.save(new Employee(employee.getEmp_Id(), employee.getEmp_Name(), employee.getDepartment()));
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("emp")
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            List<Employee> employees = employeeRepository.findAll();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Optional<Employee> employeeData = employeeRepository.findById(id);
        return employeeData.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("emp/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeRepository.findById(id);
        return employeeData.map(existingEmployee -> {
            existingEmployee.setEmp_Name(employee.getEmp_Name());
            existingEmployee.setDepartment(employee.getDepartment());
            return new ResponseEntity<>(employeeRepository.save(existingEmployee), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("emp/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
        try {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

	
