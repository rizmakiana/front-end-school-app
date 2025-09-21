/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.school.app.service;

import com.unindra.school.app.util.AppManager;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author rizmakiana
 */
public class ComboBoxUtil {
    
    public static String[] getDateList() {
        return IntStream.rangeClosed(1, 31).mapToObj(i -> String.valueOf(i)).toArray(String[]::new);
    }

    public static String[] getMonthList() {
        return Arrays.stream(Month.values()).map(i -> i.getDisplayName(TextStyle.FULL, AppManager.getLocale()))
                .toArray(String[]::new);
    }

    public static String[] getYearListStudent() {

        int thisYear = Year.now().getValue();

        return IntStream.iterate(thisYear - 5, y -> y >= thisYear - 17, y -> y - 1)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
    }
    
    public static String[] getYearListTeacher() {

        int thisYear = Year.now().getValue();

        return IntStream.iterate(thisYear - 18, y -> y >= thisYear - 50, y -> y - 1)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
    }
    
    public static String[] getYearOfTwoSemester(){
        
        int thisMonth = YearMonth.now().getMonthValue();
        int thisYear = (thisMonth > 6) ? Year.now().getValue() + 1: Year.now().getValue();
        
        return IntStream.iterate(thisYear, y -> y >= thisYear - 1, y -> y - 1 )
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
    }
    
}
