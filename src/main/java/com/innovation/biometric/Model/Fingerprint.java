package com.innovation.biometric.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Fingerprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fingerPrintRec;

    @OneToOne
    @JoinColumn(name = "member_id", unique = true)
    private Member member;


}
