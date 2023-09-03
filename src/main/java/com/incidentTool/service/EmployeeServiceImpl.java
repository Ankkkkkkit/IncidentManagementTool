package com.incidentTool.service;


import com.incidentTool.entities.Employee;
import com.incidentTool.entities.Login;
import com.incidentTool.repository.EmployeeRepository;
import com.incidentTool.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Employee registerEmpDetails(Employee empInfo){

        Employee emp=new Employee();
        Optional<Login> login=loginRepository.findById(empInfo.getEmp_id()).stream().findFirst();
        emp.setEmp_id(empInfo.getEmp_id());
        emp.setEmail(empInfo.getEmail());
        emp.setDesignation(empInfo.getDesignation());
        emp.setName(empInfo.getName());
        emp.setPh_no(empInfo.getPh_no());


        return employeeRepository.save(emp);
    }

}
