/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.MemberBUS;
import DTO.MemberDTO;
import GUI.Component.ManagementTable;
import GUI.Component.MenuBar;
import GUI.Component.MenuBarButton;
import GUI.Member.MemberDialog;
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
public class MemberPanel extends javax.swing.JPanel {

    ManagementTable tablePanel = new ManagementTable();
    MenuBar menuBar = new MenuBar();
    MenuBarButton addBtn = new MenuBarButton("Thêm", "add.svg", new Color(173, 169, 178), "add");
    
    MemberBUS memberBUS = new MemberBUS();
    ArrayList<MemberDTO> memberList = memberBUS.getAllMember();
    
    public MemberPanel() {
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
        String[] columnNames = {"Mã thành viên", "Họ tên", "Số điện thoại", "Địa chỉ", "Ngày tham gia", "Trạng thái"};
        tablePanel.table.setModel(new DefaultTableModel(null, columnNames));
        loadDataToTable(memberList);
        
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
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn thành viên nào");
                    return;
                }
                viewEvent();
            }
        });
    }
    
    public void loadDataToTable(ArrayList<MemberDTO> memberList) {
        DefaultTableModel tableModel = (DefaultTableModel) tablePanel.table.getModel();
        tableModel.setRowCount(0);
        for (MemberDTO i : memberList) {
            tableModel.addRow(new Object[] {
                    i.getMember_id(),
                    i.getFull_name(),
                    i.getPhone(),
                    i.getAddress(),
                    Formatter.getDate(i.getMembership_date()),
                    i.getStatus()
            });
        }
    }
    
    public void viewEvent() {
        int index = tablePanel.table.getSelectedRow();
        int id = (int) tablePanel.table.getValueAt(index, 0);
        MemberDTO member = memberBUS.getById(id);
        MemberDialog mD = new MemberDialog(null, true, member, "view");
        mD.setVisible(true);
        memberList = memberBUS.getAllMember();
        loadDataToTable(memberList);
    }
    
    public void addEvent() {
        MemberDialog mD = new MemberDialog(null, true, null, "add");
        mD.setVisible(true);
        memberList = memberBUS.getAllMember();
        loadDataToTable(memberList);
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
