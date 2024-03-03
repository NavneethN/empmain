package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Department;

//@RepositoryRestResource(collectionResourceRel ="departments",path="departments")
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
