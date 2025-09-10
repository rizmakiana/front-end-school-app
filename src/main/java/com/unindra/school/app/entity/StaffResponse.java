/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.school.app.entity;

import com.unindra.school.app.model.Gender;
import java.time.LocalDate;

/**
 *
 * @author rizmakiana
 */
public class StaffResponse {
    
    private String id;
    
    private String name;

    private Gender gender;

    private String username;

    private LocalDate birthDate;

    private String email;

    private String phoneNumber;

    private DistrictResponse districtResponse;

    public StaffResponse() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }    

    public void setDistrictResponse(DistrictResponse districtResponse) {
        this.districtResponse = districtResponse;
    }

    public DistrictResponse getDistrictResponse() {
        return districtResponse;
    }
    
    
}
