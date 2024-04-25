package com.innovation.biometric.Controller;

import com.innovation.biometric.Model.HealthOfficer;
import com.innovation.biometric.Model.Member;
import com.innovation.biometric.Services.HealthOfficerServices;
import com.innovation.biometric.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OfficerController {

    @Autowired
    private HealthOfficerServices healthOfficerServices;

    @Autowired
    private UserService userService;

    @GetMapping("/getAllOfficers")
    public List<HealthOfficer> getAll(){
        return healthOfficerServices.getAll();
    }

    @GetMapping("/getOfficer/{id}")
    public HealthOfficer getOfficerById(@PathVariable Long id){
        return healthOfficerServices.getOfficerById(id);
    }

//    @PostMapping({"/addOfficer"})
//    public HealthOfficer addOfficer(@RequestBody HealthOfficer healthOfficer){
//        return (HealthOfficer) userService.registerHealthOfficer(healthOfficer);
//    }

    @PutMapping("/updateOfficer/{id}")
    public void updateOfficer(@PathVariable Long id, @RequestBody HealthOfficer healthOfficer){
        healthOfficerServices.updateOfficer(id, healthOfficer);
    }

    @DeleteMapping("/deleteOfficer/{id}")
    public void delete(@PathVariable Long id){
        healthOfficerServices.deleteOfficer(id);
    }
}

