package com.example.service;

import com.example.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

    private static final List<Employee> emps = new ArrayList<>();

    static {
        emps.add(new Employee("Apple", "Project Engg"));
        emps.add(new Employee("Boy", "Project Manager"));
        emps.add(new Employee("Cat", "Senior Dev"));
        emps.add(new Employee("Dog", "Trainee"));
        emps.add(new Employee("Elephant", "CEO"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return emps;
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return emps.stream().filter(employee -> employee.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByRole(String role) {
        return emps.stream().filter(employee -> employee.getRole().equalsIgnoreCase(role)).collect(Collectors.toList());
    }

    @Override
    public boolean addEmployee(Employee e) {
        return emps.add(e);
    }

    @Override
    public boolean addEmployee(String name, String role) {
        return emps.add(new Employee(name, role));
    }

    @Override
    public Employee getEmployeesByIndex(int i) {
        return emps.get(i);
    }
}
