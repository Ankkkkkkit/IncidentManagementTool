package com.incidentTool.controller;

import com.incidentTool.entities.Department;

import com.incidentTool.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // create employees
    @PostMapping("/DeptInformation")
    public Department createUser(@RequestBody Department deptDetail){
        return departmentService.createUser(deptDetail);
    }
}
