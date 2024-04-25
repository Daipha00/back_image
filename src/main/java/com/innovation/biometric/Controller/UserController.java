package com.innovation.biometric.Controller;

import com.innovation.biometric.Services.UserService;
import com.innovation.biometric.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    private void initUserRoles(){
        userService.initUserRoles();
    }


@PostMapping({"/registerNewUser"})
public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
}

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible by admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible by user";
    }

}
