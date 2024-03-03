package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "emp_Id")
    private int emp_Id;
	@Column(name = "emp_Name")
    private String emp_Name;
	   @ManyToOne
	    @JoinColumn(name = "dept_id")
	    @JsonIgnore
 
    private Department department;

    // Constructor
    
    public Employee() {
    }
    public Employee(int emp_Id, String emp_Name, Department department) {
        this.emp_Id = emp_Id;
        this.emp_Name = emp_Name;
        this.department = department;
    }

    // Getters and Setters
    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [emp_Id=" + emp_Id + ", emp_Name=" + emp_Name + ", department=" + department + "]";
    }
}
