package com.innovation.biometric.Reposiory;

import com.innovation.biometric.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
}
