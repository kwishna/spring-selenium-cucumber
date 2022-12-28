package com.example.service;

import com.example.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeesByRole(String role);
    Employee getEmployeesByIndex(int index);
    boolean addEmployee(Employee e);
    boolean addEmployee(String name, String role);
}
