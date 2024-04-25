package com.innovation.biometric.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data

public class Member extends User{


    private String memberName;
    private String gender;
    private LocalDate dob;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Fingerprint fingerprint;


    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private MemberImage memberImage;

     @ManyToOne
     @JoinColumn(name = "officer_id")
     private HealthOfficer healthOfficer;


    public Member() {
    }


    public Member(String memberName, String gender, LocalDate dob, LocalDate issueDate, LocalDate expiryDate) {
        this.memberName = memberName;
        this.gender = gender;
        this.dob = dob;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public Member(String userName, String userPassword, String userFirstName, String userLastName, String address, String email, String phoneNumber, MemberImage memberImage) {
        super(userName, userPassword, userFirstName, userLastName, address, email, phoneNumber);
        this.memberImage = memberImage;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public MemberImage getMemberImage() {
        return memberImage;
    }

    public void setMemberImage(Set<MemberImage> memberImage) {
        this.memberImage = (MemberImage) memberImage;
    }
}
