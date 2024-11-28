/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.PurchaseTicketBUS;
import BUS.StaffBUS;
import BUS.SupplierBUS;
import DTO.PurchaseTicketDTO;
import GUI.Component.ManagementTable;
import GUI.Component.MenuBar;
import GUI.Component.MenuBarButton;
import GUI.PurchaseTicket.PurchaseTicketDialog;
import helper.Formatter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duc3m
 */
public class PurchasePanel extends javax.swing.JPanel {

    ManagementTable tablePanel = new ManagementTable();
    MenuBar menuBar = new MenuBar();
    MenuBarButton addBtn = new MenuBarButton("Thêm", "add.svg", new Color(173, 169, 178), "add");
    
    SupplierBUS supplierBUS = new SupplierBUS();
    StaffBUS staffBUS = new StaffBUS();
    PurchaseTicketBUS purchaseTicketBUS = new PurchaseTicketBUS();
    
    ArrayList<PurchaseTicketDTO> purchaseTicketList = purchaseTicketBUS.getAllPurchaseTicket();
    
    public PurchasePanel() {
        initComponents();
        customInit();
    }

    public void customInit() {
        //Đặt menuBar và table lên layer 100
        menuBar.setBounds(14, 20, 940, 150);
        jLayeredPane1.add(menuBar, Integer.valueOf(100));
        tablePanel.setBounds(14, 180, 940, 600);
        jLayeredPane1.add(tablePanel, Integer.valueOf(100));
        
        //Quy định các cột
        String[] columnNames = {"Mã phiếu nhập", "Nhà cung cấp", "Nhân viên", "Ngày nhập", "Trạng thái"};
        tablePanel.table.setModel(new DefaultTableModel(null, columnNames));
        loadDataToTable(purchaseTicketList);
        
        menuBar.btn_refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                refreshTable();
            }
        });
        
        menuBar.jToolBar1.add(addBtn);
        addBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                addEvent();
            }
        });
        
        tablePanel.viewOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tablePanel.table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiếu nhập nào");
                    return;
                }
                viewEvent();
            }
        });
    }
    
    public void loadDataToTable(ArrayList<PurchaseTicketDTO> purchaseTicketList) {
        DefaultTableModel tableModel = (DefaultTableModel) tablePanel.table.getModel();
        tableModel.setRowCount(0);
        for (PurchaseTicketDTO i : purchaseTicketList) {
            tableModel.addRow(new Object[] {
                    i.getId(),
                    supplierBUS.getById(i.getSupplier_id()).getName(),
                    staffBUS.getById(i.getStaff_id()).getFullName(),
                    Formatter.getDate(i.getPurchase_date()),
                    i.getStatus(),
            });
        }
    }
    
    public void refreshTable() {
        purchaseTicketList = purchaseTicketBUS.getAllPurchaseTicket();
        loadDataToTable(purchaseTicketList);
    }
    
    public void viewEvent() {
        int index = tablePanel.table.getSelectedRow();
        int id = (int) tablePanel.table.getValueAt(index, 0);
        PurchaseTicketDTO purchaseTicket = purchaseTicketBUS.getById(id);
        PurchaseTicketDialog ptD = new PurchaseTicketDialog(null, true, purchaseTicket, "view");
        ptD.setVisible(true);
        refreshTable();
    }
    
    public void addEvent() {
        PurchaseTicketDialog ptD = new PurchaseTicketDialog(null, true, null, "add");
        ptD.setVisible(true);
        refreshTable();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(980, 830));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background/product_background1.jpg"))); // NOI18N

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
