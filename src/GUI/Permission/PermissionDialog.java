/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Permission;

import BUS.FunctionBUS;
import BUS.PermissionBUS;
import BUS.PermissionDetailBUS;
import DAO.PermissionDAO;
import DTO.FunctionDTO;
import DTO.PermissionDTO;
import DTO.PermissionDetailDTO;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Duc3m
 */
public final class PermissionDialog extends javax.swing.JDialog {

    JCheckBox[][] checkBoxList;
    String[] actionKey = {"view", "add", "edit", "delete"};
    String[] action = {"Xem", "Thêm", "Sửa", "Xóa"};
    private int functionSize, actionSize;
    
    private FunctionBUS functionBUS = new FunctionBUS();
    private ArrayList<FunctionDTO> functionList = functionBUS.getAll();
    ArrayList<PermissionDetailDTO> permissionDetailList;
    PermissionDetailBUS permissionDetailBUS = new PermissionDetailBUS();
    PermissionBUS permissionBUS = new PermissionBUS();
    PermissionDTO permission;
    
    public PermissionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        customInit();
    }
    
    public PermissionDialog(java.awt.Frame parent, PermissionDTO permission, boolean modal) {
        super(parent, modal);
        this.permission = permission;
        initComponents();
        customInit();
        if(permission != null) 
            initData();
    }
    
    public void customInit() {
        setLocationRelativeTo(null);
        
        actionSize = actionKey.length;
        functionSize = functionList.size();
        this.checkBoxList = new JCheckBox[functionSize][actionSize];
        
        pnl_function.setLayout(new GridLayout(functionSize + 1, 1));
        pnl_actionLabel.setLayout(new GridLayout(1, actionSize));
        pnl_checkbox.setLayout(new GridLayout(functionSize, actionSize));
        
        JLabel tenCN = new JLabel("Tên chức năng");
        tenCN.setHorizontalAlignment(SwingConstants.CENTER);
        tenCN.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pnl_function.add(tenCN);
        
        for(int i=0; i<functionSize; i++) {
            JLabel jlb = new JLabel(functionList.get(i).getName());
            jlb.setHorizontalAlignment(SwingConstants.CENTER);
            jlb.setFont(new Font("Segoe UI", Font.BOLD, 12));
            pnl_function.add(jlb);
        }
        
        for(int i=0; i<actionSize ; i++) {
            JLabel jlb = new JLabel(action[i]);
            jlb.setHorizontalAlignment(SwingConstants.CENTER);
            jlb.setFont(new Font("Segoe UI", Font.BOLD, 12));
            pnl_actionLabel.add(jlb);
        }
        
        for(int i=0; i<functionSize; i++) {
            for(int j=0; j<actionSize; j++) {
                checkBoxList[i][j] = new JCheckBox();
                checkBoxList[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                pnl_checkbox.add(checkBoxList[i][j]);
            }
        }
        
        enablingForm(false);
    }
    
    public void initData() {
        permissionDetailList = permissionDetailBUS.getByPermissionId(permission.getId());
        txtName.setText(permission.getName());
        for(PermissionDetailDTO k : permissionDetailList) {
            for(int i=0; i<functionSize; i++) 
                for(int j=0; j<actionSize; j++) {
                    if(k.getFunction_id() == functionList.get(i).getId()
                            && k.getAction().equals(actionKey[j])) {
                        checkBoxList[i][j].setSelected(true);
                    }
                }
        }
    }
    
    public ArrayList<PermissionDetailDTO> getPermissionDetailList(int quyenId) {
        ArrayList<PermissionDetailDTO> result = new ArrayList<>();
        for(int i=0; i<functionSize; i++) {
            for(int j=0; j<actionSize; j++) {
                if(checkBoxList[i][j].isSelected()) {
                    PermissionDetailDTO permissionDetail = new PermissionDetailDTO(
                            quyenId, 
                            functionList.get(i).getId(), 
                            actionKey[j]
                    );
                    result.add(permissionDetail);
                }
            }
        }
        return result;
    }
    
    public void enablingForm(boolean enabled) {
        txtName.setFocusable(enabled);
        for(JCheckBox[] i : checkBoxList)
            for(JCheckBox j : i)
                j.setEnabled(enabled);
    }
    
    public boolean validation() {
        ArrayList<PermissionDTO> permissionList = permissionBUS.getAll();
        for(PermissionDTO i : permissionList) {
            if(this.permission != null)
                if(this.permission.getId() == i.getId())
                    continue;
            if(txtName.getText().equals(i.getName()))
               return false;
        }
        return true;
    }
    
    public void addEvent() {
        if(!validation()) {
            JOptionPane.showMessageDialog(this, "Nhóm quyền đã tồn tại");
            return;
        }
        
        String name = txtName.getText();
        PermissionDTO newPermission = new PermissionDTO(name);
        int id = permissionBUS.addReturnId(newPermission);
        ArrayList<PermissionDetailDTO> pdList = getPermissionDetailList(id);
        
        if(permissionDetailBUS.add(pdList) == true) {
            JOptionPane.showMessageDialog(this, "Thêm nhóm quyền mới thành công");
            dispose();
        }
    }
    
    public void editEvent() {
        if(!validation()) {
            JOptionPane.showMessageDialog(this, "Nhóm quyền đã tồn tại");
            return;
        }
        
        this.permission.setName(txtName.getText());
        ArrayList<PermissionDetailDTO> pdList = getPermissionDetailList(this.permission.getId());
        
        if(permissionBUS.update(permission, pdList) == true) {
            JOptionPane.showMessageDialog(this, "Lưu thay đổi thành công");
            dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnl_center = new javax.swing.JPanel();
        pnl_function = new javax.swing.JPanel();
        pnl_action = new javax.swing.JPanel();
        pnl_actionLabel = new javax.swing.JPanel();
        pnl_checkbox = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(24, 144, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên nhóm quyền");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        pnl_center.setLayout(new java.awt.BorderLayout());

        pnl_function.setBackground(new java.awt.Color(255, 255, 255));
        pnl_function.setPreferredSize(new java.awt.Dimension(150, 500));
        pnl_function.setLayout(new java.awt.GridLayout(1, 9));
        pnl_center.add(pnl_function, java.awt.BorderLayout.LINE_START);

        pnl_action.setLayout(new java.awt.BorderLayout());

        pnl_actionLabel.setBackground(new java.awt.Color(255, 255, 255));
        pnl_actionLabel.setPreferredSize(new java.awt.Dimension(780, 32));
        pnl_actionLabel.setLayout(new java.awt.GridLayout(1, 4));
        pnl_action.add(pnl_actionLabel, java.awt.BorderLayout.PAGE_START);

        pnl_checkbox.setBackground(new java.awt.Color(255, 255, 255));
        pnl_checkbox.setLayout(new java.awt.GridLayout(8, 4));
        pnl_action.add(pnl_checkbox, java.awt.BorderLayout.CENTER);

        pnl_center.add(pnl_action, java.awt.BorderLayout.CENTER);

        jPanel2.add(pnl_center, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(212, 209, 216)));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 50));

        jButton1.setBackground(new java.awt.Color(21, 154, 32));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Lưu");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(244, 67, 54));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Hủy");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 215, 64));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sửa");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        if(this.permission != null)
            editEvent();
        else
            addEvent();
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        dispose();
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        enablingForm(true);
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnl_action;
    private javax.swing.JPanel pnl_actionLabel;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_checkbox;
    private javax.swing.JPanel pnl_function;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
