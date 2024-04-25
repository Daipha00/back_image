package com.innovation.biometric.Services;

import com.innovation.biometric.Model.HealthOfficer;
import com.innovation.biometric.Model.Member;
import com.innovation.biometric.Reposiory.HealthOfficerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthOfficerServices {

    @Autowired
    private HealthOfficerRepo healthOfficerRepo;

    public HealthOfficer  addOfficer(HealthOfficer healthOfficer){
       return healthOfficerRepo.save(healthOfficer);
    }

    public List<HealthOfficer> getAll() {
        return healthOfficerRepo.findAll();
    }

    public HealthOfficer getOfficerById(long id) {
        return healthOfficerRepo.findById(id).orElse(null);
    }

    public void updateOfficer(Long id, HealthOfficer healthOfficer) {
        HealthOfficer existingOfficer = healthOfficerRepo.findById(id).orElse(null);
        if (existingOfficer != null) {
            existingOfficer.setCenterDistrict(healthOfficer.getCenterDistrict());
            existingOfficer.setCenterRegion(healthOfficer.getCenterRegion());
            existingOfficer.setCenterName(healthOfficer.getCenterName());
            healthOfficerRepo.save(existingOfficer);
        }
    }

    public void deleteOfficer(Long id){
        healthOfficerRepo.deleteById(id);
    }


}
