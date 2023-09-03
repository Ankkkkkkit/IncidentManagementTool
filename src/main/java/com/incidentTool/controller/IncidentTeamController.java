package com.incidentTool.controller;

import com.incidentTool.entities.IncidentTeam;
import com.incidentTool.service.IncidentTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teamInfo")
public class IncidentTeamController {

    @Autowired
    private IncidentTeamService incidentTeamService;

    // create employees
    @PostMapping("/teamInformation")
    public IncidentTeam createUser(@RequestBody IncidentTeam incidentTeamDetail){
        return incidentTeamService.createIncidentTeam(incidentTeamDetail);
    }
}
