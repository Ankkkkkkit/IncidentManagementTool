package com.incidentTool.service;


import com.incidentTool.entities.Incident;

import java.util.List;

public interface IncidentService {

    Incident createIncident(Incident incidentInfo);

    List<Incident> getIncidents(Long empId);

    public Incident saveIssue(Incident incidentDetails);
}
