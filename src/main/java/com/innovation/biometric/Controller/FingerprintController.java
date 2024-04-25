package com.innovation.biometric.Controller;

import com.innovation.biometric.Model.Fingerprint;
import com.innovation.biometric.Services.FingerprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FingerprintController {


    @Autowired
    private FingerprintService fingerprintService;

    @GetMapping("/getAllFingerprint")
    public List<Fingerprint> getAll(){
        return fingerprintService.getAll();
    }

    @GetMapping("/getFingerprint/{id}")
    public Fingerprint getFingerprintById(@PathVariable Long id){
        return fingerprintService.getFingerprintById(id);
    }

    @PostMapping("/addFingerprint")
    public Fingerprint addFingerprint(@RequestBody Fingerprint fingerprint) {
       return fingerprintService.addFingerprint(fingerprint);
    }

//    @PostMapping("/create")
//    public ResponseEntity<Fingerprint> createFingerprint(@RequestBody Fingerprint fingerprint) {
//        Fingerprint savedFingerprint = fingerprintService.addFingerprint(fingerprint);
//        return new ResponseEntity<>(savedFingerprint, HttpStatus.CREATED);
//    }

    @PutMapping("/updateFingerprint/{id}")
    public void updateFingerprint(@PathVariable Long id, @RequestBody Fingerprint fingerprint){
        fingerprintService.updateFingerprint(id, fingerprint);
    }

    @DeleteMapping("/deleteFingerprint/{id}")
    public void delete(@PathVariable Long id){
        fingerprintService.deleteFingerprint(id);
    }

}
