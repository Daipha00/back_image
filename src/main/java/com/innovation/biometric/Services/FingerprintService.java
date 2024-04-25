package com.innovation.biometric.Services;

import com.innovation.biometric.Model.Fingerprint;
import com.innovation.biometric.Reposiory.FingerprintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FingerprintService {


    @Autowired
    private FingerprintRepo fingerprintRepo;

    public List<Fingerprint> getAll() {
        return fingerprintRepo.findAll();
    }

    public Fingerprint getFingerprintById(Long id) {
        return fingerprintRepo.findById(id).orElse(null);
    }

    public Fingerprint addFingerprint (Fingerprint fingerprint) {
        return fingerprintRepo.save(fingerprint);
    }

    public void updateFingerprint(Long id, Fingerprint fingerprint){
        Fingerprint existingFingerprint = fingerprintRepo.findById(id).orElse(null);
        if (existingFingerprint != null) {
            existingFingerprint.setFingerPrintRec(fingerprint.getFingerPrintRec());
        }
    }

    public void deleteFingerprint(Long id){
        fingerprintRepo.deleteById(id);
    }
}
