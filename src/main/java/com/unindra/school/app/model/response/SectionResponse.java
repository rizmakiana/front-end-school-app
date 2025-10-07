/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.school.app.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rizmakiana
 */
@Data
@NoArgsConstructor
public class SectionResponse {
    
    private String id;

    private String departmentName;

    private String classroomName;

    private Character name;

    private String code;

    private Integer totalStudent;
    
}
