/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Component;

import GUI.Main_Frame;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Duc3m
 */
public class SideNav_Button extends javax.swing.JPanel implements MouseListener{

    public Color enteredColor = new Color(105, 110, 110);
    public Color exitedColor = new Color(243, 243, 245);
    public Color enteredFontColor = new Color(255, 255, 255);
    public Color exitedFontColor = new Color(20, 17, 21);
    public Color logoutButtonColor = new Color(0, 199, 190);
    public Color logoutButtonHoverColor = new Color(199, 0, 76);
    
    Main_Frame main;
    String target;
    String name;
    public boolean isSelected = false;
    public boolean isLogoutButton = false;
    
    public SideNav_Button() {
        initComponents();
        addMouseListener(this);
    }

    public SideNav_Button(Main_Frame main, String name, String target, String imageLink) {
        initComponents();
        putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        this.main = main;
        this.name = name;
        this.target = target;
        text.setText(name);
        icon.setIcon(new FlatSVGIcon("./svg/icon/" + imageLink));
        addMouseListener(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        text = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 245));
        setPreferredSize(new java.awt.Dimension(260, 50));

        icon.setBackground(new java.awt.Color(255, 255, 255));
        icon.setPreferredSize(new java.awt.Dimension(30, 30));

        text.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        text.setForeground(new java.awt.Color(20, 17, 21));
        text.setText("Button's name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!isLogoutButton)
            main.switchCard(target);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!isSelected && !isLogoutButton) {
            setBackground(enteredColor);
            text.setForeground(enteredFontColor);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(isLogoutButton) {
            setBackground(logoutButtonHoverColor);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!isSelected && !isLogoutButton) {
            setBackground(exitedColor);
            text.setForeground(exitedFontColor);
        }
        if(isLogoutButton) {
            setBackground(logoutButtonColor);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    public javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
