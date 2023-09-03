package com.incidentTool.service;

import com.incidentTool.entities.Login;
import com.incidentTool.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login createUser(Login userDetails) {
       return loginRepository.save(userDetails);
    }

    @Override
    public Optional<Login> findEmpIfExists(Long empId) {
        return loginRepository.existsById(empId) ? loginRepository.findById(empId).stream().findFirst():Optional.empty();
    }


}
