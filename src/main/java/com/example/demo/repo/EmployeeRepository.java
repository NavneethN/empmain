
package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Employee;


//@RepositoryRestResource(collectionResourceRel ="employees",path="employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
