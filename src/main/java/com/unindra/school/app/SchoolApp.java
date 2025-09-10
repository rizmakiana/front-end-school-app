/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.unindra.school.app;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.unindra.school.app.util.AppManager;
import com.unindra.school.app.view.SelectRoleView;

import java.util.Locale;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author rizmakiana
 */
public class SchoolApp {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        Locale.setDefault(AppManager.getLocale());
        
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        SelectRoleView view = new SelectRoleView();
        view.setVisible(true);
    }
}
