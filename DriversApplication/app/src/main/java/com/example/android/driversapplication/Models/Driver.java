package com.example.android.driversapplication.Models;

/**
 * Created by Android on 05.09.2017.
 */

public class Driver {
    private  String name;
    private  String srName;
    private long phone1;
    private long phone2;
    private String passport;
    private String address;
    private String autoNumber;
    private String autoPassport;
    private String status;
    private String uid;

    public Driver() {

    }

    public Driver(String name, String srName, long phone1, long phone2, String passport, String address, String autoNumber, String autoPassport) {
        this.name = name;
        this.srName = srName;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.passport = passport;
        this.address = address;
        this.autoNumber = autoNumber;
        this.autoPassport = autoPassport;
        //this.uid = passport;
        status = "offLine";
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName;
    }

    public long getPhone1() {
        return phone1;
    }

    public void setPhone1(int phone1) {
        this.phone1 = phone1;
    }

    public long getPhone2() {
        return phone2;
    }

    public void setPhone2(int phone2) {
        this.phone2 = phone2;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(String autoNumber) {
        this.autoNumber = autoNumber;
    }

    public String getAutoPassport() {
        return autoPassport;
    }

    public void setAutoPassport(String autoPassport) {
        this.autoPassport = autoPassport;
    }
}
