package com.unindra.school.app.util;


import com.unindra.school.app.model.response.TokenResponse;
import java.util.Locale;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rizmakiana
 */
public class AppManager {
    
    private static boolean lightMode = true;
    
    private static Locale locale = Locale.forLanguageTag("en-US");
    
    private final static String webName = "http://localhost:8080";
    
    private final static char defaultPasswordChar = '•';
    
    private static TokenResponse token;

    public static char getDefaultPasswordChar() {
        return defaultPasswordChar;
    }
    
    

    public static void setToken(TokenResponse token) {
        AppManager.token = token;
    }

    public static TokenResponse getToken() {
        return token;
    }
    
    public static String getWebName(){
        return AppManager.webName;
    }
    
    public static boolean getLightMode(){
        return AppManager.lightMode;
    }
    
    public static void setLightMode(boolean bool) throws UnsupportedLookAndFeelException{
        AppManager.lightMode = bool;
        applyTheme();
    }
    
    public static void setLocale(Locale locale){
        AppManager.locale = locale;
    }

    public static Locale getLocale() {
        return locale;
    }
    
    public static void applyTheme() throws UnsupportedLookAndFeelException {
        
        if (lightMode) {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } else {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        }

        for (java.awt.Window window : java.awt.Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window);
        }

    }
}
