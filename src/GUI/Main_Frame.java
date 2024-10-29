/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.AccountDTO;
import GUI.Component.SideNav;
import GUI.Panel.AccountPanel;
import GUI.Panel.BorrowPanel;
import GUI.Panel.ReturnPanel;
import GUI.Panel.MemberPanel;
import GUI.Panel.StaffPanel;
import GUI.Panel.HomePanel;
import GUI.Panel.PermissionPanel;
import GUI.Panel.ProductPanel;
import GUI.Panel.ImportPanel;
import GUI.Panel.PenaltyPanel;
import GUI.Panel.StatisticPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Duc3m
 */
public class Main_Frame extends javax.swing.JFrame {

    public SideNav sideNav;
    public JPanel content = new JPanel();
    private Color MainColor = new Color(255, 255, 255);
    public CardLayout cardLayout;
    
    public HomePanel homePanel = new HomePanel();
    public ProductPanel productPanel = new ProductPanel();
    public BorrowPanel borrowPanel = new BorrowPanel();
    public ReturnPanel returnPanel = new ReturnPanel();
    public StaffPanel staffPanel = new StaffPanel();
    public MemberPanel memberPanel = new MemberPanel();
    public StatisticPanel statisticPanel = new StatisticPanel();
    public ImportPanel importPanel = new ImportPanel();
    public PenaltyPanel penaltyPanel = new PenaltyPanel();
    public AccountPanel accountPanel = new AccountPanel();
    public PermissionPanel permissionPanel = new PermissionPanel();
    
    public Main_Frame() {
        initComponents();
        customInit();
    }
      
    public void customInit() {
        setTitle("Quản lý thư viện");
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0, 0));
        sideNav = new SideNav(this);
        content.setSize(new Dimension(980, 830));
        content.setBackground(MainColor);
        content.setLayout(new CardLayout(0, 0));
        getContentPane().add(content, BorderLayout.CENTER);
        getContentPane().add(sideNav, BorderLayout.WEST);
        
        cardLayout = (CardLayout) content.getLayout();
        content.add(homePanel, "home");
        content.add(productPanel, "book");
        content.add(borrowPanel, "borrow");
        content.add(returnPanel, "return");
        content.add(importPanel, "import");
        content.add(staffPanel, "staff");
        content.add(memberPanel, "member");
        content.add(accountPanel, "account");
        content.add(penaltyPanel, "penalty");
        content.add(permissionPanel, "permission");
        content.add(statisticPanel, "statistic");
    }

    public void switchCard(String panelName) {
        cardLayout.show(content, panelName);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thư viện");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(1280, 830));
        setResizable(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
