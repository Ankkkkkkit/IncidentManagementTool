package com.incidentTool.service;

import com.incidentTool.entities.Employee;
import com.incidentTool.entities.IncidentTeam;
import com.incidentTool.repository.EmployeeRepository;
import com.incidentTool.repository.IncidentTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IncidentTeamImpl implements IncidentTeamService{

    @Autowired
    private IncidentTeamRepository incidentTeamRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public IncidentTeam createIncidentTeam(IncidentTeam incidentTeamInfo){

        IncidentTeam team =new IncidentTeam();
        Optional<Employee> employee=employeeRepository.findById(incidentTeamInfo.getEmpid()).stream().findFirst();

        team.setIncident_type(incidentTeamInfo.getIncident_type());
        team.setEmpid(incidentTeamInfo.getEmpid());
        team.setTaskCapacity(incidentTeamInfo.getTaskCapacity());
        team.setTaskCapacity(incidentTeamInfo.getTaskCapacity());

        return incidentTeamRepository.save(team);
    }
}
