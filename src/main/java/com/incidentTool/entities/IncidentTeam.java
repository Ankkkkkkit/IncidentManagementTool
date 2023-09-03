package com.incidentTool.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="INCIDENT_TEAM")
public class IncidentTeam {

    @Id
    private Long empid;

    @OneToMany(mappedBy = "incidentTeams")
    private List<Incident> incidentId=new ArrayList<>();

    private int taskCounter;
    private int taskCapacity;
    private String incident_type;

    public Long getEmpid() {
        return empid;
    }

    public String getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(String incident_type) {
        this.incident_type = incident_type;
    }

    public int getTaskCapacity() {
        return taskCapacity;
    }

    public void setTaskCapacity(int taskCapacity) {
        this.taskCapacity = taskCapacity;
    }

    public int getTaskCounter() {
        return taskCounter;
    }

    public void setTaskCounter(int taskCounter) {
        this.taskCounter = taskCounter;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
    }

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "incidentTeam")
    private Employee employee;


}
