/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Component;

import DTO.AccountDTO;
import DTO.SessionManager;
import GUI.Main_Frame;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author Duc3m
 */
public class SideNav extends javax.swing.JPanel {

    Main_Frame main;
    String[][] menuNames = {
        {"Trang chủ", "home", "home.svg"},
        {"Quản lý sách", "book", "book.svg"},
        {"Mượn sách", "borrow", "borrow.svg"},
        {"Trả sách", "return", "return.svg"},
        {"Nhập sách", "import", "receipt.svg"},
        {"Nhân viên", "staff", "employee.svg"},
        {"Thành viên", "member", "customer.svg"},
        {"Tài khoản", "account", "account.svg"},
        {"Vi phạm", "penalty", "namecard.svg"},
        {"Phân quyền", "permission", "permission.svg"},
        {"Thống kê", "statistic", "statistic.svg"},
        {"Đăng xuất", "logout", "door.svg"}
    };
    public SideNav_Button menuButtons[];
    AccountDTO account = SessionManager.getInstance().getLoggedInAccount();
    
    public SideNav() {
        initComponents();
        
        JPanel blankSpace = new JPanel();
        blankSpace.setPreferredSize(new Dimension(300, 30));
        blankSpace.setBackground(Color.white);
        centerPanel.add(blankSpace);

    }
    
    public SideNav(Main_Frame main) {
        initComponents();     
        this.main = main;
        menuButtons = new SideNav_Button[menuNames.length];
        //Tao cac nut cho menu
        for(int i = 0; i < menuNames.length; i++) {
            menuButtons[i] = new SideNav_Button(main, menuNames[i][0], menuNames[i][1], menuNames[i][2]);
            
            //Neu khong phai nut dang xuat
            if(i != menuNames.length - 1) {
                //Them MouseEvent
                menuButtons[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt) {
                        selectingMenuItem(evt);
                    }
                });
            }
            //Doi mau neu la nut dang xuat
            else {
                menuButtons[i].isLogoutButton = true;
                menuButtons[i].setBackground(menuButtons[i].logoutButtonColor);
                menuButtons[i].text.setForeground(Color.white);
            }
            centerPanel.add(menuButtons[i]);
        }
        
        //Doi mau cho nut dau tien
        menuButtons[0].isSelected = true;
        menuButtons[0].setBackground(menuButtons[0].enteredColor);
        menuButtons[0].text.setForeground(menuButtons[0].enteredFontColor);
        
        user_icon.setIcon(new FlatSVGIcon("./svg/icon/user_female.svg"));
    }
    
    public void selectingMenuItem(MouseEvent evt) {
        for (int i = 0; i < menuNames.length - 1; i++) {
            if (evt.getSource() == menuButtons[i]) {
                menuButtons[i].isSelected = true;
                menuButtons[i].setBackground(menuButtons[i].enteredColor);
                menuButtons[i].text.setForeground(menuButtons[i].enteredFontColor);
            } else {
                menuButtons[i].isSelected = false;
                menuButtons[i].setBackground(menuButtons[i].exitedColor);
                menuButtons[i].text.setForeground(menuButtons[i].exitedFontColor);
            }
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user_icon = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        setInheritsPopupMenu(true);
        setMaximumSize(new java.awt.Dimension(300, 830));
        setMinimumSize(new java.awt.Dimension(1, 0));
        setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(255, 255, 255));
        topPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(108, 107, 116)));
        topPanel.setPreferredSize(new java.awt.Dimension(300, 90));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Nguyễn Thùy Trang");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Quản lý cửa hàng");

        user_icon.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(user_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user_icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(new java.awt.Color(255, 255, 255));
        centerPanel.setToolTipText("");
        centerPanel.setPreferredSize(new java.awt.Dimension(300, 740));
        centerPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 8));
        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel user_icon;
    // End of variables declaration//GEN-END:variables
}
