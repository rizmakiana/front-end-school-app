/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.school.app.model;

/**
 *
 * @author rizmakiana
 */
public class RegionResponse {
    
    private String id;
    
    private String name;

    public String getId() { return id; }
    
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return this.name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionResponse that = (RegionResponse) o;
        return id.equals(that.id); // bandingkan hanya id
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
     public RegionResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public RegionResponse() {
    }
     
    
    
}
