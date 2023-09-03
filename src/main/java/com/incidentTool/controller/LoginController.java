package com.incidentTool.controller;

import com.incidentTool.entities.Login;
import com.incidentTool.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
//@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage(){

        return "login"; // Returns login.html
    }

    // create employees
    @PostMapping("/login")
    public String createUser(@RequestBody String loginPayload, RedirectAttributes redirectAttributes){
        System.out.println(loginPayload);
        String loginArr [] = loginPayload.split("&");
        String username = loginArr[0].split("=")[1]; // "username=1"=> .split("=") -> [username,1] -> newArray[1] -> 1
        String password = loginArr[1].split("=")[1]; // "password=Temp123" -> Temp@123
        Long empId = Long.parseLong(username);
        Optional<Login> isEmpExists = loginService.findEmpIfExists(empId);
        System.out.println(password == isEmpExists.get().getPassword());
        if(isEmpExists.isPresent()){
            if(password == isEmpExists.get().getPassword()){
                redirectAttributes.addAttribute("username",isEmpExists.get().getEmail());
                redirectAttributes.addAttribute("empId",isEmpExists.get().getEmp_id());
                return "redirect:/dashboard";
            }
            else{
                return "redirect:/login?error=true";
            }
        }

        return "redirect:/login?error=true";

    }
}
