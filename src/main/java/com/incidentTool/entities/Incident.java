package com.incidentTool.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Date;

/**
 *         DDL – Data Definition Language -> creation
 *         DQL – Data Query Language -> select
 *         DML – Data Manipulation Language -> alter
 *         DCL – Data Control Language -> drop
 *         TCL – Transaction Control Language -> transaction "very important"
 */
@Entity
@Table(name="incident")
public class Incident{



    private Long reporter_id;

    @Nullable
    private Long assigned_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="incident&incidentTeam",referencedColumnName = "empid")
    private IncidentTeam incidentTeams;

    @ManyToOne
    @JoinColumn(name="emp_id")
    private Employee employee;


    private String status;

    private String severity;

    private String description;

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long incidentId;

    private Date reported_date;

    private Date rectified_date;

    public Long getReporter_id() {
        return reporter_id;
    }

    public void setReporter_id(Long reporter_id) {
        this.reporter_id = reporter_id;
    }

    public Long getAssigned_id() {
        return assigned_id;
    }

    public void setAssigned_id(Long assigned_id) {
        this.assigned_id = assigned_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIncidentId() {
        return incidentId;
    }

    public Date getReported_date() {
        return reported_date;
    }

    public void setReported_date(Date reported_date) {
        this.reported_date = reported_date;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public Date getRectified_date() {
        return rectified_date;
    }

    public void setRectified_date(Date rectified_date) {
        this.rectified_date = rectified_date;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "reporter_id=" + reporter_id +
                ", assigned_id=" + assigned_id +
                ", incidentTeams=" + incidentTeams +
                ", employee=" + employee +
                ", status='" + status + '\'' +
                ", severity='" + severity + '\'' +
                ", description='" + description + '\'' +
                ", incidentId=" + incidentId +
                ", reported_date=" + reported_date +
                ", rectified_date=" + rectified_date +
                '}';
    }
}