/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.PurchaseTicket;

import BUS.StaffBUS;
import BUS.SupplierBUS;
import DTO.BookDTO;
import DTO.PurchaseTicketDTO;
import DTO.PurchaseTicketDetailDTO;
import DTO.SessionManager;
import DTO.StaffDTO;
import DTO.SupplierDTO;
import GUI.Book.BookDialog;
import GUI.Book.GetBookDialog;
import GUI.Staff.GetStaffDialog;
import GUI.Supplier.GetSupplierDialog;
import helper.Formatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Duc3m
 */
public class PurchaseTicketDialog extends javax.swing.JDialog {

    StaffDTO staff;
    SupplierDTO supplier;
    PurchaseTicketDTO purchaseTicket;
    String mode;
    
    StaffBUS staffBUS = new StaffBUS();
    SupplierBUS supplierBUS = new SupplierBUS();
    
    ArrayList<PurchaseTicketDetailDTO> detailList;
    
    public PurchaseTicketDialog(java.awt.Frame parent, boolean modal, PurchaseTicketDTO purchaseTicket, String mode) {
        super(parent, modal);
        this.purchaseTicket = purchaseTicket;
        this.mode = mode;
        initComponents();
        customInit();
    }
    
    public void customInit() {
        setLocationRelativeTo(null);
        
        jButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                addBookEvent();
            }
        });
        
        btn_save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(mode.equals("add"))
                    addEvent();
            }
        });
        
        btn_exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        
        if(mode.equals("view"))
            initViewMode();
        if(mode.equals("add"))
            initAddMode();
    }
    
    public void initViewMode() {
        
    }
    
    public void initAddMode() {
        lbl_title.setText("TẠO PHIẾU NHẬP MỚI");
        detailList = new ArrayList<>();
        staff = SessionManager.getInstance().getLoggedInStaff();
        txt_staff.setText(staff.getFullName());
        
        txt_purchaseDate.setText(Formatter.getDate(new Timestamp(System.currentTimeMillis())));
        
        lbl_id.setEnabled(false);
        txt_id.setEnabled(false);
        lbl_status.setEnabled(false);
        txt_status.setEnabled(false);
    }
    
    public void addBookEvent() {
        String[] option = {"Tạo sách mới", "Chọn sách", "Hủy"};
        int selection = JOptionPane.showOptionDialog(null, "Bạn muốn nhập sản sách mới hay chọn sách có sẵn?", "", 0, 3, null, option, option[2]);
        //Tao sach moi
        if(selection == 0) {
            BookDialog bDialog = new BookDialog(null, true, null, "add");
            bDialog.setVisible(true);
        }
        if(selection == 1) {
            BookDTO book = GetBookDialog.getBook();
            if(book == null)
                return;
            
        }
    }
    
    public void generateBookItemList() {
        
    }
    
    public PurchaseTicketDTO getNewPurchaseTicket() {
        int supplier_id = supplier.getSupplier_id();
        int staff_id = staff.getId();
        Timestamp purchase_date = new Timestamp(System.currentTimeMillis());
        String status = "1";
        
        return new PurchaseTicketDTO(supplier_id, staff_id, purchase_date, status);
    }
    
    public void addEvent() {
        purchaseTicket = getNewPurchaseTicket();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_supplier = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_staff = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_purchaseDate = new javax.swing.JTextField();
        lbl_status = new javax.swing.JLabel();
        txt_status = new javax.swing.JTextField();
        btn_supplier = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbl_title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_save = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(212, 209, 216)));
        jPanel2.setPreferredSize(new java.awt.Dimension(686, 80));

        lbl_id.setText("Mã");

        txt_id.setFocusable(false);

        jLabel2.setText("Nhà cung cấp");

        txt_supplier.setFocusable(false);
        txt_supplier.setPreferredSize(new java.awt.Dimension(150, 30));

        jLabel3.setText("Nhân viên");

        txt_staff.setFocusable(false);

        jLabel4.setText("Ngày nhập");

        txt_purchaseDate.setFocusable(false);

        lbl_status.setText("Trạng thái");

        txt_status.setFocusable(false);

        btn_supplier.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btn_supplier.setText("...");
        btn_supplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_supplier.setFocusPainted(false);
        btn_supplier.setMaximumSize(new java.awt.Dimension(40, 40));
        btn_supplier.setPreferredSize(new java.awt.Dimension(70, 40));
        btn_supplier.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_supplier.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_staff, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(lbl_status)
                    .addComponent(txt_purchaseDate)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_id)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_supplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_purchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_staff, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("CHI TIẾT PHIẾU NHẬP");
        lbl_title.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(212, 209, 216)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbl_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btn_save.setBackground(new java.awt.Color(21, 154, 32));
        btn_save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Đồng ý");
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.setFocusPainted(false);

        btn_exit.setBackground(new java.awt.Color(244, 67, 54));
        btn_exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_exit.setText("Hủy");
        btn_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exit.setFocusPainted(false);

        jButton1.setBackground(new java.awt.Color(88, 175, 232));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm sách");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        supplier = GetSupplierDialog.getSupplier();
        if(supplier == null)
            return;
        txt_supplier.setText(supplier.getName());
    }//GEN-LAST:event_btn_supplierActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_purchaseDate;
    private javax.swing.JTextField txt_staff;
    private javax.swing.JTextField txt_status;
    private javax.swing.JTextField txt_supplier;
    // End of variables declaration//GEN-END:variables
}
