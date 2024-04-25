package com.innovation.biometric.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MemberImage {

    @Id
    private Long id;
    private String name;
    private String type;
    @Column(length = 50000000)
    private byte[] picByte;

    @OneToOne
    @JoinColumn(name = "member_id", unique = true)
    private Member member;

    public MemberImage() {
    }

    public MemberImage(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
