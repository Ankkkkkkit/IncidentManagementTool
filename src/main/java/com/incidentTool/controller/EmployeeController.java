package com.incidentTool.controller;

import com.incidentTool.entities.Employee;
import com.incidentTool.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // create employees
    @PostMapping("/info")
    public Employee registerEmpDetails(@RequestBody Employee empDetail){
        return employeeService.registerEmpDetails(empDetail);
    }

}
