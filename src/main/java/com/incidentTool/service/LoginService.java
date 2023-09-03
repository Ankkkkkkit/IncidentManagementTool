package com.incidentTool.service;


import com.incidentTool.entities.Login;

import java.util.Optional;

public interface LoginService {
    Login createUser(Login userDetails);

    Optional<Login> findEmpIfExists(Long empId);
}
