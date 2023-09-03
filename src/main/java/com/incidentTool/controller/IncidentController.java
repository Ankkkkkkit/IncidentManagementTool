package com.incidentTool.controller;


import com.fasterxml.jackson.core.JsonParser;
import com.incidentTool.entities.Incident;

import com.incidentTool.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/incidentInformation")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    // create employees
    @PostMapping("/information")
    public Incident createUser(@RequestBody Incident incidentDetail){
        return incidentService.createIncident(incidentDetail);
    }

    @GetMapping("/previous-incidents")
    public String showPreviousIncidents(@RequestParam(name = "username", required = false) String username, Model model) {
        // Fetch the list of issues from the database using your IssueService
        List<Incident> issueList = incidentService.getIncidents(Long.parseLong(username));

        // Add the issueList and username to the model
        model.addAttribute("incidents", issueList);
        model.addAttribute("username", username);

        return "previous-incidents";
    }

    @GetMapping("/log-incident")
    public String showLogIssuePage(@RequestParam(name = "username", required = false) String username,Model model) {
        model.addAttribute("username", username);
        return "log-incident"; // Return the Thymeleaf HTML page for logging issues
    }

    @PostMapping("/log-incident")
    public String logIssue( @RequestParam String reporterId,
                            @RequestParam String severity,
                            @RequestParam String description,Model model) {

        Incident incidentDetails = new Incident();
        incidentDetails.setReporter_id(Long.parseLong(reporterId));
        incidentDetails.setStatus("Not Started");
        incidentDetails.setDescription(description);
        incidentDetails.setReported_date(new Date());
        incidentDetails.setSeverity(severity);
        // Save the issue data to the database using IncidentService
        Incident incident = incidentService.saveIssue(incidentDetails);
        String issueMessage=ObjectUtils.isEmpty(incident) ? "Failed to logIn Incident Right now ! Please try again later...":"Successfully Logged Your Incident . We will reach out to you as soon as someone from the support looks into it .";
        model.addAttribute("issueMessage",issueMessage);
        return "redirect:log-incident"; // Redirect to the log issue page after submission
    }


}
