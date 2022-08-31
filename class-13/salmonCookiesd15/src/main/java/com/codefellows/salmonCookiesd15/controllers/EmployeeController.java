package com.codefellows.salmonCookiesd15.controllers;

import com.codefellows.salmonCookiesd15.models.Employee;
import com.codefellows.salmonCookiesd15.models.SalmonCookieStore;
import com.codefellows.salmonCookiesd15.repositories.EmployeeRepository;
import com.codefellows.salmonCookiesd15.repositories.SalmonCookiesStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    SalmonCookiesStoreRepository salmonCookiesStoreRepository;

    @GetMapping("/employees")
    public String getAllEmployees(Model m){
        // get all employees info from all stores from DATABASE!
        List<Employee> employees = employeeRepository.findAll();
        // then send to thymeleaf through the model
        m.addAttribute("employees", employees);
        return "salmon-cookies/employees";
    }

    @PostMapping("/add-employee")
    public RedirectView addEmployeeToStore(String employeeName, Float payPerHour, String store){
        // we want to create and employee
            // we have to gather the data
        SalmonCookieStore salmonCookieStore = salmonCookiesStoreRepository.findByName(store);
        Employee newEmployee = new Employee(employeeName, payPerHour, salmonCookieStore);
        employeeRepository.save(newEmployee);

        return new RedirectView("/");
    }

}
