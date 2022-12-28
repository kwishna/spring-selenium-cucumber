package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController // Shorthand For @Controller & @ResponseBody
@Controller
@RequestMapping("api")
public class EmployeeController {

    @Autowired
    EmployeeService empl;

    @RequestMapping(value = {"/employees/all", "/", ""}, method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployee() {
        //  http://localhost:8080/api/employees
        return empl.getAllEmployees();
    }

    @RequestMapping(value = "/employees/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployeeByName(@PathVariable(name = "name") String name) {
        // http://localhost:8080/api/employees/name/dog
        return empl.getEmployeesByName(name);
    }

    @RequestMapping(value = "/employees/role/{role}", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployeeByRole(@PathVariable(name = "role") String role) {
        // http://localhost:8080/api/employees/role/ceo
        return empl.getEmployeesByRole(role);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployeeByIndex(@RequestParam(value = "id") int index) {
        // http://localhost:8080/api/employees?id=1
        return empl.getEmployeesByIndex(index + 1);
    }

    @ResponseBody
    @RequestMapping(value = "/setemployee", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public boolean setEmployeeByRole(@RequestBody Employee e) {
        return empl.addEmployee(e);
    }
}
