package com.incidentTool.service;

import com.incidentTool.entities.Employee;
import com.incidentTool.entities.Incident;

import com.incidentTool.repository.EmployeeRepository;
import com.incidentTool.repository.IncidentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Incident createIncident(Incident incidentInfo){

        Incident inc=new Incident();
        Optional<Employee> employee=employeeRepository.findById(incidentInfo.getReporter_id()).stream().findFirst();

        inc.setReporter_id(incidentInfo.getReporter_id());
        inc.setStatus(incidentInfo.getStatus());
        inc.setSeverity(incidentInfo.getSeverity());
        inc.setDescription(incidentInfo.getDescription());
        inc.setReported_date(incidentInfo.getReported_date());
        inc.setRectified_date(incidentInfo.getRectified_date());

        return incidentRepository.save(inc);
    }

    @Override
    public List<Incident> getIncidents(Long empId) {
        System.out.println("Data::"+incidentRepository.findByReporterId(empId).stream().findFirst().toString());
        return incidentRepository.findByReporterId(empId);
    }

    @Override
    public Incident saveIssue(Incident incidentDetails) {
        try{
            Incident savedIncidentDetail=incidentRepository.save(incidentDetails);
            return ObjectUtils.isEmpty(savedIncidentDetail) ? null : savedIncidentDetail;
        }catch(Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }
    }

}
