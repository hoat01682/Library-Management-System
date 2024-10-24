/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Permission;

import BUS.FunctionBUS;
import DTO.FunctionDTO;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Duc3m
 */
public class PermissionDialog extends javax.swing.JDialog {

    JCheckBox[][] checkBoxList;
    String[] actionKey = {"view", "add", "edit", "delete"};
    String[] action = {"Xem", "Thêm", "Sửa", "Xóa"};
    private int functionSize, actionSize;
    private FunctionBUS functionBUS = new FunctionBUS();
    private ArrayList<FunctionDTO> functionList = functionBUS.getAll();
    
    public PermissionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initComponentsCustom();
    }
    
    public void initComponentsCustom() {
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
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(24, 144, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 50));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên nhóm quyền");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        pnl_center.setLayout(new java.awt.BorderLayout());

        pnl_function.setBackground(new java.awt.Color(255, 255, 255));
        pnl_function.setPreferredSize(new java.awt.Dimension(120, 500));
        pnl_function.setLayout(new java.awt.GridLayout(1, 9));
        pnl_center.add(pnl_function, java.awt.BorderLayout.LINE_START);

        pnl_action.setLayout(new java.awt.BorderLayout());

        pnl_actionLabel.setBackground(new java.awt.Color(255, 255, 255));
        pnl_actionLabel.setPreferredSize(new java.awt.Dimension(780, 50));
        pnl_actionLabel.setLayout(new java.awt.GridLayout(1, 4));
        pnl_action.add(pnl_actionLabel, java.awt.BorderLayout.PAGE_START);

        pnl_checkbox.setBackground(new java.awt.Color(255, 255, 255));
        pnl_checkbox.setLayout(new java.awt.GridLayout(8, 4));
        pnl_action.add(pnl_checkbox, java.awt.BorderLayout.CENTER);

        pnl_center.add(pnl_action, java.awt.BorderLayout.CENTER);

        jPanel2.add(pnl_center, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 50));

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jButton1)
                .addGap(151, 151, 151)
                .addComponent(jButton2)
                .addContainerGap(330, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnl_action;
    private javax.swing.JPanel pnl_actionLabel;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_checkbox;
    private javax.swing.JPanel pnl_function;
    // End of variables declaration//GEN-END:variables
}
