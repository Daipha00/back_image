package com.innovation.biometric.Services;

import com.innovation.biometric.Model.Member;
import com.innovation.biometric.Reposiory.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {


    @Autowired
    private MemberRepo memberRepo;

    public List<Member> getAll() {
        return memberRepo.findAll();
    }

    public Member getMemberById(long id) {
        return memberRepo.findById(id).orElse(null);
    }


    public Member addMember(Member member){return memberRepo.save(member);
    }

    public void updateMember(Long id, Member member) {
        Member existingMember = memberRepo.findById(id).orElse(null);
        if (existingMember != null) {
            existingMember.setDob(member.getDob());
            existingMember.setGender(member.getGender());
            existingMember.setIssueDate(member.getIssueDate());
            existingMember.setExpiryDate(member.getExpiryDate());

            memberRepo.save(existingMember);
        }
    }

    public void deleteMember(Long id) {memberRepo.deleteById(id);
    }
}
