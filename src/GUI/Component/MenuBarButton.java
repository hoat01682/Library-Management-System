/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Component;

import com.formdev.flatlaf.extras.FlatSVGIcon;
//import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class MenuBarButton extends JButton{
    public String function;
        
    public MenuBarButton(String text, String icon, String function) {
        this.function = function;
        this.setMargin(new Insets(8, 20, 8, 20));
        this.setFont(new Font("Segoe UI", Font.BOLD, 14));
        this.setForeground(new Color(255, 255, 255));
        this.setIcon(new FlatSVGIcon("./svg/icon/" + icon));
        this.setText(text);
        this.setFocusable(false);
        this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.putClientProperty("JButton.buttonType", "toolBarButton");
        this.setOpaque(true);
    }
    
    public MenuBarButton(String text, String icon, Color color,String function) {
        this.function = function;
        this.setBackground(color);
        this.setMargin(new Insets(8, 12, 8, 12));
        this.setFont(new Font("Segoe UI", Font.BOLD, 14));
        this.setForeground(new Color(255, 255, 255));
        this.setIcon(new FlatSVGIcon("./svg/icon/" + icon));
        this.setText(text);
        this.setFocusable(false);
        this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.putClientProperty("JButton.buttonType", "toolBarButton");
        this.setOpaque(true);
    }
    
    public String getPermisson() {
        return this.function;
    }
}
