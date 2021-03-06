package com.example.android.driversapplication.Models;

/**
 * Created by Android on 06.09.2017.
 */

public class TaxiDriver {
    private  String name;
    private  String srName;
    private long phone1;
    private long phone2;
    private String passport;
    private String address;
    private String autoNumber;
    private String autoPassport;
    private int seats;
    private String uid;
    private String status;

    public TaxiDriver() {

    }

    public TaxiDriver(String name, String srName, long phone1, long phone2, String passport, String address, String autoNumber, String autoPassport, int seats) {
        this.name = name;
        this.srName = srName;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.passport = passport;
        this.address = address;
        this.autoNumber = autoNumber;
        this.autoPassport = autoPassport;
        this.seats = seats;
        status = "oFFline";
       // this.uid = passport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setPhone1(long phone1) {
        this.phone1 = phone1;
    }

    public long getPhone2() {
        return phone2;
    }

    public void setPhone2(long phone2) {
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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
