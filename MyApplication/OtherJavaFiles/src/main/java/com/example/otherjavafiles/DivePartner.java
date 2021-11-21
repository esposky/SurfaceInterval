package com.example.otherjavafiles;

import java.io.Serializable;

public class DivePartner implements Serializable {

    private String userID;
    private int partnerID;
    private String name;
    private String certNum;
    private String role;

    public DivePartner(String userID, int partnerID, String name, String number, String role){
        setUserID(userID);
        setPartnerID(partnerID);
        setName(name);
        setCertNum(number);
        setRole(role);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public String getName() {
        String temp = name;
        return temp;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getCertNum() {
        String temp = certNum;
        return temp;
    }

    private void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public String getRole() {
        String temp = role;
        return temp;
    }

    private void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", CertNum: " + getCertNum() + ", Role: " + getRole();
    }
}