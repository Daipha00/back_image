package com.innovation.biometric.Model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class HealthOfficer extends User{

//    @Id
//    private Long Id;
    private String centerName;
    private String centerDistrict;
    private String centerRegion;

@OneToMany(mappedBy = "healthOfficer", cascade = CascadeType.ALL)
    private List<Member> member = new ArrayList<>();
}
