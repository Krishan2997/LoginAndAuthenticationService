package com.rentler.restservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class UserData{

    @Id
    String userId;

    @Column(name = "FirstName")
    String fName;

    @Column(name = "LastName")
    String lName;

    @Column(name = "PhoneNumber")
    String phoneNumber;

    @Column(name = "EmailId")
    String emailId;

    @Column(name = "AddressLine1")
    String address1;

    @Column(name = "AddressLine2")
    String address2;

    @Column(name = "City")
    String city;

    @Column(name = "State")
    String state;

    @Column(name = "Country")
    String country;

    @Column(name = "Password")
    String password;

    public UserData(String userId,
                    String userName,
                    String fName,
                    String lName,
                    String phoneNumber,
                    String emailId,
                    String address1,
                    String address2,
                    String city,
                    String state,
                    String country,
                    String password) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.password=password;
    }

    public UserData(){}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password=password;
    }
}
