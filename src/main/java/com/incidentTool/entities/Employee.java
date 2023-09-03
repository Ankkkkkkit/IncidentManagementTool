package com.incidentTool.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
    @Id
    private Long emp_id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER) // EAGER -> Instantly & LAZY -> Load when needed
    @JoinColumn(name = "emp_dept_id",referencedColumnName = "dept_id")
    private Department department;

    @Column(unique = true)
    private String email;
    private long ph_no;
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public long getPh_no() {
        return ph_no;
    }

    public void setPh_no(long ph_no) {
        this.ph_no = ph_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Login login;

    @OneToOne
    @JoinColumn(name="incidentTeam_emp")
    private IncidentTeam incidentTeam;

    @OneToMany(mappedBy = "employee")
    private Set<Incident> incidents;


}
