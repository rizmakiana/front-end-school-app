/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.school.app.components;

import com.unindra.school.app.model.response.RegionResponse;
import javax.swing.JComboBox;

/**
 *
 * @author rizmakiana
 */
public class RegionComboBox extends JComboBox<RegionResponse>{
    
    public RegionComboBox() {
        super();
    }

    // Bisa tambahin helper biar gampang
    public void setItems(java.util.List<RegionResponse> items) {
        this.removeAllItems();
        for (RegionResponse r : items) {
            this.addItem(r);
        }
    }

    public RegionResponse getSelectedRegion() {
        return (RegionResponse) this.getSelectedItem();
    }

}
