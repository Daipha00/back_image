package com.innovation.biometric.Reposiory;

import com.innovation.biometric.Model.Fingerprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FingerprintRepo extends JpaRepository<Fingerprint, Long> {
}
