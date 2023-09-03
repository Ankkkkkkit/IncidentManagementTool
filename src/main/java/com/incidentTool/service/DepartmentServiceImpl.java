package com.incidentTool.service;

import com.incidentTool.entities.Department;

import com.incidentTool.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department createUser(Department deptDetails) {
        return departmentRepository.save(deptDetails);
    }
}
