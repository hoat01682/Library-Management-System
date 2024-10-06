/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Permission;

import GUI.ActionOnGUI;
import GUI.Home_Frame;
import GUI.Member.EditMember_Frame;
import GUI.Member.AddMember_Frame;

/**
 *
 * @author hieun
 */
public class Permission_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Supplier_Frame
     */
    public Permission_Frame() {
        initComponents();
        
        ActionOnGUI.disposeAndOpenNewFrame(Permission_Frame.this, new Home_Frame()); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add_Button = new javax.swing.JButton();
        edit_Button = new javax.swing.JButton();
        details_Button = new javax.swing.JButton();
        Separator1 = new javax.swing.JSeparator();
        search_TextField = new javax.swing.JTextField();
        refresh_Button = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        permission_Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        add_Button.setBackground(new java.awt.Color(82, 196, 26));
        add_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        add_Button.setForeground(new java.awt.Color(255, 255, 255));
        add_Button.setText("Thêm");
        add_Button.setBorderPainted(false);
        add_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_Button.setFocusPainted(false);
        add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ButtonActionPerformed(evt);
            }
        });

        edit_Button.setBackground(new java.awt.Color(250, 173, 20));
        edit_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        edit_Button.setForeground(new java.awt.Color(255, 255, 255));
        edit_Button.setText("Sửa");
        edit_Button.setBorderPainted(false);
        edit_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit_Button.setFocusPainted(false);
        edit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_ButtonActionPerformed(evt);
            }
        });

        details_Button.setBackground(new java.awt.Color(24, 144, 255));
        details_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        details_Button.setForeground(new java.awt.Color(255, 255, 255));
        details_Button.setText("Chi tiết");
        details_Button.setBorderPainted(false);
        details_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        details_Button.setFocusPainted(false);
        details_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                details_ButtonActionPerformed(evt);
            }
        });

        Separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        search_TextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        refresh_Button.setBackground(new java.awt.Color(24, 144, 255));
        refresh_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        refresh_Button.setForeground(new java.awt.Color(255, 255, 255));
        refresh_Button.setText("Làm mới");
        refresh_Button.setBorderPainted(false);
        refresh_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refresh_Button.setFocusPainted(false);
        refresh_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_ButtonActionPerformed(evt);
            }
        });

        permission_Table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        permission_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã nhóm quyền", "Tên nhóm quyền"
            }
        ));
        ScrollPane.setViewportView(permission_Table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edit_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(details_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refresh_Button)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edit_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(details_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Separator1)
                        .addComponent(search_TextField)
                        .addComponent(refresh_Button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ButtonActionPerformed
        new AddPermission_Frame().setVisible(true);
    }//GEN-LAST:event_add_ButtonActionPerformed

    private void edit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_ButtonActionPerformed
        EditPermission_Frame editPermission_Frame = new EditPermission_Frame();
        editPermission_Frame.setVisible(true); 
    }//GEN-LAST:event_edit_ButtonActionPerformed

    private void refresh_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_ButtonActionPerformed
        
    }//GEN-LAST:event_refresh_ButtonActionPerformed

    private void details_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_details_ButtonActionPerformed
        new PermissionDetails_Frame().setVisible(true); 
    }//GEN-LAST:event_details_ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Permission_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Permission_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Permission_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Permission_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Permission_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JSeparator Separator1;
    private javax.swing.JButton add_Button;
    private javax.swing.JButton details_Button;
    private javax.swing.JButton edit_Button;
    private javax.swing.JTable permission_Table;
    private javax.swing.JButton refresh_Button;
    private javax.swing.JTextField search_TextField;
    // End of variables declaration//GEN-END:variables
}
