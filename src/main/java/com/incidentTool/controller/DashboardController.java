package com.incidentTool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(@RequestParam(name = "username", required = false) String username, Model model){
        System.out.println("entered "+ username + " " + model.asMap());
        model.addAttribute("username",username);
        model.addAttribute("empId",username);
        return "dashboard";
    }
}
