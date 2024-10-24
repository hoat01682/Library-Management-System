/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Component;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duc3m
 */
public class ManagementTable extends javax.swing.JPanel {

    //Thong so border radius
    int arc = 40; 
            
    public ManagementTable() {
        initComponents();
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(105, 110, 118));
        table.getTableHeader().setForeground(Color.white);
//        String[] columnNames = {"Column 1", "Column 2", "Column 3"};
//        Object[][] data = {
//            {"Data 1", "Data 2", "Data 3"},
//            {"Data 4", "Data 5", "Data 6"},
//            {"Data 7", "Data 8", "Data 9"},
//            {"Data 1", "Data 2", "Data 3"},          
//        };
//        table.setModel(new DefaultTableModel(data, columnNames));
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        viewOption = new javax.swing.JMenuItem();
        editOption = new javax.swing.JMenuItem();
        deleteOption = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jPopupMenu1.setBackground(new java.awt.Color(255, 255, 255));

        viewOption.setText("Xem chi tiết");
        viewOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOptionActionPerformed(evt);
            }
        });
        jPopupMenu1.add(viewOption);

        editOption.setText("Sửa");
        jPopupMenu1.add(editOption);

        deleteOption.setForeground(new java.awt.Color(255, 51, 51));
        deleteOption.setText("Xóa");
        jPopupMenu1.add(deleteOption);

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(900, 560));

        table.setBackground(new java.awt.Color(212, 209, 216));
        table.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên sản phẩm", "Số lượng tồn", "Tên tác giả", "Danh mục", "Năm xuất bản", "Nhà xuất bản", "Khu vực sách"
            }
        ));
        table.setComponentPopupMenu(jPopupMenu1);
        table.setFocusable(false);
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setRowHeight(24);
        table.setSelectionBackground(new java.awt.Color(0, 153, 204));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOptionActionPerformed
        System.out.println(table.getSelectedRow());
    }//GEN-LAST:event_viewOptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem deleteOption;
    private javax.swing.JMenuItem editOption;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table;
    private javax.swing.JMenuItem viewOption;
    // End of variables declaration//GEN-END:variables
}
