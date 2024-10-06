/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Staff;

import BUS.StaffBUS;
import DTO.StaffDTO;
import GUI.ActionOnGUI;
import GUI.Home_Frame;
import GUI.Style;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author hieun
 */
public class Staff_Frame extends javax.swing.JFrame {

    StaffBUS staffBUS = new StaffBUS();

    /**
     * Creates new form Staff_Panel
     */
    public Staff_Frame() {
        initComponents();
        Style.tableStyle(staff_Table);
                
        // Xuất dữ liệu từ database lên table
        DefaultTableModel tableModel = (DefaultTableModel) staff_Table.getModel();
        ActionOnGUI.showDataOnTable(tableModel, staffBUS.getAllStaff());  
        
        ActionOnGUI.disposeAndOpenNewFrame(Staff_Frame.this, new Home_Frame()); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPane = new javax.swing.JTabbedPane();
        staff_Panel = new javax.swing.JPanel();
        addStaff_Button = new javax.swing.JButton();
        editStaff_Button = new javax.swing.JButton();
        Separator1 = new javax.swing.JSeparator();
        searchStaff_TextField = new javax.swing.JTextField();
        statusStaff_ComboBox = new javax.swing.JComboBox<>();
        refreshStaffTable_Button = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        staff_Table = new javax.swing.JTable();
        account_Panel = new javax.swing.JPanel();
        editAccount_Button = new javax.swing.JButton();
        Separator2 = new javax.swing.JSeparator();
        searchAccount_TextField = new javax.swing.JTextField();
        statusAccount_ComboBox = new javax.swing.JComboBox<>();
        refreshAccount_Button = new javax.swing.JButton();
        ScrollPane1 = new javax.swing.JScrollPane();
        account_Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        staff_Panel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        addStaff_Button.setBackground(new java.awt.Color(82, 196, 26));
        addStaff_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addStaff_Button.setForeground(new java.awt.Color(255, 255, 255));
        addStaff_Button.setText("Thêm");
        addStaff_Button.setBorderPainted(false);
        addStaff_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addStaff_Button.setFocusPainted(false);
        addStaff_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaff_ButtonActionPerformed(evt);
            }
        });

        editStaff_Button.setBackground(new java.awt.Color(250, 173, 20));
        editStaff_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editStaff_Button.setForeground(new java.awt.Color(255, 255, 255));
        editStaff_Button.setText("Sửa");
        editStaff_Button.setBorderPainted(false);
        editStaff_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editStaff_Button.setFocusPainted(false);
        editStaff_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStaff_ButtonActionPerformed(evt);
            }
        });

        Separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        searchStaff_TextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        statusStaff_ComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusStaff_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm việc", "Đã nghỉ việc" }));
        statusStaff_ComboBox.setSelectedIndex(-1);
        statusStaff_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusStaff_ComboBoxActionPerformed(evt);
            }
        });

        refreshStaffTable_Button.setBackground(new java.awt.Color(24, 144, 255));
        refreshStaffTable_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        refreshStaffTable_Button.setForeground(new java.awt.Color(255, 255, 255));
        refreshStaffTable_Button.setText("Làm mới");
        refreshStaffTable_Button.setBorderPainted(false);
        refreshStaffTable_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshStaffTable_Button.setFocusPainted(false);
        refreshStaffTable_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshStaffTable_ButtonActionPerformed(evt);
            }
        });

        staff_Table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staff_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Email", "Số điện thoại", "Địa chỉ", "Ngày làm việc", "Trạng thái"
            }
        ));
        ScrollPane.setViewportView(staff_Table);
        if (staff_Table.getColumnModel().getColumnCount() > 0) {
            staff_Table.getColumnModel().getColumn(4).setHeaderValue("Địa chỉ");
            staff_Table.getColumnModel().getColumn(5).setHeaderValue("Ngày làm việc");
        }

        javax.swing.GroupLayout staff_PanelLayout = new javax.swing.GroupLayout(staff_Panel);
        staff_Panel.setLayout(staff_PanelLayout);
        staff_PanelLayout.setHorizontalGroup(
            staff_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staff_PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(staff_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollPane)
                    .addGroup(staff_PanelLayout.createSequentialGroup()
                        .addComponent(addStaff_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editStaff_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchStaff_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statusStaff_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshStaffTable_Button)))
                .addGap(12, 12, 12))
        );
        staff_PanelLayout.setVerticalGroup(
            staff_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staff_PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(staff_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Separator1)
                    .addGroup(staff_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addStaff_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editStaff_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refreshStaffTable_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchStaff_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusStaff_ComboBox))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        TabbedPane.addTab("Nhân viên", staff_Panel);

        account_Panel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        editAccount_Button.setBackground(new java.awt.Color(250, 173, 20));
        editAccount_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editAccount_Button.setForeground(new java.awt.Color(255, 255, 255));
        editAccount_Button.setText("Sửa");
        editAccount_Button.setBorderPainted(false);
        editAccount_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editAccount_Button.setFocusPainted(false);
        editAccount_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAccount_ButtonActionPerformed(evt);
            }
        });

        Separator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        searchAccount_TextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        statusAccount_ComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusAccount_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm việc", "Đã nghỉ việc" }));
        statusAccount_ComboBox.setSelectedIndex(-1);
        statusAccount_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusAccount_ComboBoxActionPerformed(evt);
            }
        });

        refreshAccount_Button.setBackground(new java.awt.Color(24, 144, 255));
        refreshAccount_Button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        refreshAccount_Button.setForeground(new java.awt.Color(255, 255, 255));
        refreshAccount_Button.setText("Làm mới");
        refreshAccount_Button.setBorderPainted(false);
        refreshAccount_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshAccount_Button.setFocusPainted(false);
        refreshAccount_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshAccount_ButtonActionPerformed(evt);
            }
        });

        account_Table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        account_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã tài khoản", "Tên đăng nhập", "Mật khẩu", "Chức vụ", "Trạng thái"
            }
        ));
        ScrollPane1.setViewportView(account_Table);

        javax.swing.GroupLayout account_PanelLayout = new javax.swing.GroupLayout(account_Panel);
        account_Panel.setLayout(account_PanelLayout);
        account_PanelLayout.setHorizontalGroup(
            account_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(account_PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(account_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(account_PanelLayout.createSequentialGroup()
                        .addComponent(editAccount_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchAccount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statusAccount_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshAccount_Button))
                    .addComponent(ScrollPane1))
                .addGap(12, 12, 12))
        );
        account_PanelLayout.setVerticalGroup(
            account_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(account_PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(account_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Separator2)
                    .addComponent(editAccount_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshAccount_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchAccount_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusAccount_ComboBox))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        TabbedPane.addTab("Tài khoản", account_Panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addStaff_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaff_ButtonActionPerformed
        new AddStaff_Frame().setVisible(true);
    }//GEN-LAST:event_addStaff_ButtonActionPerformed

    private void editStaff_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStaff_ButtonActionPerformed
        int index = staff_Table.getSelectedRow();
        TableModel model = staff_Table.getModel();
        
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để chỉnh sửa", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String id = model.getValueAt(index, 0).toString();
        String fullName = model.getValueAt(index, 1).toString();
        String email = model.getValueAt(index, 2).toString();
        String phone = model.getValueAt(index, 3).toString();
        String address = model.getValueAt(index, 4).toString();
        String hireDate = model.getValueAt(index, 5).toString();
        int status = ("Đang làm việc".equals(model.getValueAt(index, 6).toString())) ? 0 : 1;
        
        EditStaff_Frame editStaff_Frame = new EditStaff_Frame();
        editStaff_Frame.setVisible(true);

        editStaff_Frame.id_TextField.setText(id); 
        editStaff_Frame.fullname_TextField.setText(fullName);
        editStaff_Frame.email_TextField.setText(email);
        editStaff_Frame.phone_TextField.setText(phone);
        editStaff_Frame.address_TextField.setText(address);
        editStaff_Frame.hireDate_TextField.setText(hireDate);
        editStaff_Frame.status_ComboBox.setSelectedIndex(status); 
    }//GEN-LAST:event_editStaff_ButtonActionPerformed

    private void refreshStaffTable_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshStaffTable_ButtonActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) staff_Table.getModel();
        ActionOnGUI.showDataOnTable(tableModel, staffBUS.getAllStaff());
        
        searchStaff_TextField.setText(""); 
        statusStaff_ComboBox.setSelectedIndex(-1); 
    }//GEN-LAST:event_refreshStaffTable_ButtonActionPerformed

    private void statusStaff_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusStaff_ComboBoxActionPerformed
        int selectedIndex = statusStaff_ComboBox.getSelectedIndex();  
        DefaultTableModel model = (DefaultTableModel) staff_Table.getModel();
        ArrayList<StaffDTO> list = staffBUS.getByStatus(selectedIndex + 1);
        
        // Nếu selected index = -1 thì load lại tất cả dữ liệu của table
        if (selectedIndex == -1) {
            ActionOnGUI.showDataOnTable(model, staffBUS.getAllStaff());
        } else {
            ActionOnGUI.showDataOnTable(model, list); 
        }
    }//GEN-LAST:event_statusStaff_ComboBoxActionPerformed

    private void editAccount_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAccount_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editAccount_ButtonActionPerformed

    private void statusAccount_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusAccount_ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusAccount_ComboBoxActionPerformed

    private void refreshAccount_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshAccount_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshAccount_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Staff_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JScrollPane ScrollPane1;
    private javax.swing.JSeparator Separator1;
    private javax.swing.JSeparator Separator2;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JPanel account_Panel;
    private javax.swing.JTable account_Table;
    private javax.swing.JButton addStaff_Button;
    private javax.swing.JButton editAccount_Button;
    private javax.swing.JButton editStaff_Button;
    private javax.swing.JButton refreshAccount_Button;
    private javax.swing.JButton refreshStaffTable_Button;
    private javax.swing.JTextField searchAccount_TextField;
    private javax.swing.JTextField searchStaff_TextField;
    private javax.swing.JPanel staff_Panel;
    private javax.swing.JTable staff_Table;
    private javax.swing.JComboBox<String> statusAccount_ComboBox;
    private javax.swing.JComboBox<String> statusStaff_ComboBox;
    // End of variables declaration//GEN-END:variables
}
