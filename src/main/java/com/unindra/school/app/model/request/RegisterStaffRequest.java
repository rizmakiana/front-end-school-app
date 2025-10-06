/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.school.app.model.request;

import com.unindra.school.app.model.util.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rizmakiana
 */
@Data
@NoArgsConstructor
public class RegisterStaffRequest {
    
    private String name;

    private Gender gender;

    private String birthPlaceRegency;

    private String birthDate;

    private Integer birthMonth;

    private String birthYear;

    private String districtAddress;

    private String address;

    private String username;

    private String password;

    private String confirmPassword;

    private String email;

    private String phoneNumber;
    
}
