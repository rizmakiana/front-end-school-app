package com.unindra.school.app.model.response;


import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rizmakiana
 */
public class TokenResponse {
    
    private String token;

    private Date expiredAt;
    
    public TokenResponse(){
    }
    
    public TokenResponse(String token, Date expiredAt){
        this.token = token;
        this.expiredAt = expiredAt;                
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

        
}
