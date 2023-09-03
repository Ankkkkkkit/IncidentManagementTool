package com.incidentTool.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dept_id;
    private String dept_name;

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @OneToMany(mappedBy="department")
    private List<Employee> name=new ArrayList<>();



    public long getDept_id() {
        return dept_id;
    }
    public void setDept_id(long dept_id) {
        this.dept_id = dept_id;
    }


}
