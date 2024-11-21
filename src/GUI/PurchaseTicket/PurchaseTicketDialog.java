package GUI.PurchaseTicket;

import BUS.BookBUS;
import BUS.PurchaseTicketBUS;
import BUS.PurchaseTicketDetailBUS;
import BUS.SupplierBUS;
import BUS.StaffBUS;
import DTO.BookDTO;
import DTO.PurchaseTicketDTO;
import DTO.PurchaseTicketDetailDTO;
import DTO.SupplierDTO;
import DTO.SessionManager;
import DTO.StaffDTO;
import GUI.Supplier.GetSupplierDialog;
import helper.Formatter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PurchaseTicketDialog extends javax.swing.JDialog {

    String mode;
    SupplierDTO supplier;
    StaffDTO staff;

    PurchaseTicketBUS purchaseTicketBUS = new PurchaseTicketBUS();
    PurchaseTicketDetailBUS purchaseTicketDetailBUS = new PurchaseTicketDetailBUS();
    BookBUS bookBUS = new BookBUS();
    SupplierBUS supplierBUS = new SupplierBUS();
    StaffBUS staffBUS = new StaffBUS();

    PurchaseTicketDTO purchaseTicket;
    ArrayList<PurchaseTicketDetailDTO> purchaseTicketDetailList;

    public PurchaseTicketDialog(java.awt.Frame parent, boolean modal, PurchaseTicketDTO purchaseTicket, String mode) {
        super(parent, modal);
        this.purchaseTicket = purchaseTicket;
        this.mode = mode;
        initComponents();
        customInit();
    }

    public void customInit() {
        setLocationRelativeTo(null);

        btn_exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });

        btn_supplier.addActionListener((ActionEvent e) -> {
            GetSupplierDialog sd = new GetSupplierDialog(null, true);
            sd.setVisible(true);
            if (sd.isChosen()) {
                int supplier_id = sd.getSelectedId();
                supplier = supplierBUS.getById(supplier_id);
                txt_supplier.setText(supplier.getName());
            }
        });

        if (mode.equals("view"))
            initViewMode();
        if (mode.equals("add"))
            initAddMode();
    }

    public void initViewMode() {
        initData();
        loadDataToTable(purchaseTicketDetailList);
        txt_id.setText(purchaseTicket.getId());
        txt_supplier.setText(supplier.getName());
        txt_staff.setText(staff.getFullName());
        txt_purchaseDate.setText(Formatter.getDate(purchaseTicket.getPurchaseDate()));
        txt_status.setText(purchaseTicket.getStatus());

        btn_supplier.setEnabled(false);
    }

    public void initData() {
        purchaseTicketDetailList = purchaseTicketDetailBUS.getByPurchaseTicketId(purchaseTicket.getId());
        supplier = supplierBUS.getById(purchaseTicket.getSupplierId());
        staff = staffBUS.getById(purchaseTicket.getStaffId());
    }

    public void initAddMode() {
        staff = SessionManager.getInstance().getLoggedInStaff();
        txt_staff.setText(staff.getFullName());
        txt_purchaseDate.setText(Formatter.getDate(new Timestamp(System.currentTimeMillis())));
    }

    public void loadDataToTable(ArrayList<PurchaseTicketDetailDTO> detailsList) {
        DefaultTableModel tableModel = (DefaultTableModel) table_items.getModel();
        tableModel.setRowCount(0);
        for (PurchaseTicketDetailDTO detail : detailsList) {
            BookDTO book = bookBUS.getByISBN(detail.getIsbn());
            tableModel.addRow(new Object[]{
                book.getId(),
                detail.getIsbn(),
                book.getTitle(),
                detail.getQuantity()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // Generated Code
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        panel_top = new javax.swing.JPanel();
        label_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        label_supplier = new javax.swing.JLabel();
        txt_supplier = new javax.swing.JTextField();
        btn_supplier = new javax.swing.JButton();
        label_staff = new javax.swing.JLabel();
        txt_staff = new javax.swing.JTextField();
        label_date = new javax.swing.JLabel();
        txt_purchaseDate = new javax.swing.JTextField();
        label_status = new javax.swing.JLabel();
        txt_status = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        table_items = new javax.swing.JTable();
        panel_bottom = new javax.swing.JPanel();
        btn_save = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_addItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel_main.setBackground(new java.awt.Color(255, 255, 255));

        panel_top.setBackground(new java.awt.Color(255, 255, 255));
        panel_top.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu nhập"));

        label_id.setText("Mã phiếu:");

        txt_id.setEditable(false);

        label_supplier.setText("Nhà cung cấp:");

        txt_supplier.setEditable(false);

        btn_supplier.setText("...");
        btn_supplier.setFocusable(false);

        label_staff.setText("Nhân viên:");

        txt_staff.setEditable(false);

        label_date.setText("Ngày nhập:");

        txt_purchaseDate.setEditable(false);

        label_status.setText("Trạng thái:");

        txt_status.setEditable(false);

        javax.swing.GroupLayout panel_topLayout = new javax.swing.GroupLayout(panel_top);
        panel_top.setLayout(panel_topLayout);
        panel_topLayout.setHorizontalGroup(
            panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_topLayout.createSequentialGroup()
                        .addComponent(label_supplier)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_topLayout.createSequentialGroup()
                        .addComponent(txt_supplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_staff)
                    .addComponent(txt_staff, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_date)
                    .addComponent(txt_purchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_status)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panel_topLayout.setVerticalGroup(
            panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_id)
                    .addComponent(label_supplier)
                    .addComponent(label_staff)
                    .addComponent(label_date)
                    .addComponent(label_status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_staff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_purchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "ISBN", "Tên sách", "Số lượng"
            }
        ));
        scrollPane.setViewportView(table_items);

        panel_bottom.setBackground(new java.awt.Color(255, 255, 255));

        btn_save.setText("Lưu");
        btn_save.setBackground(new java.awt.Color(21, 154, 32));
        btn_save.setForeground(new java.awt.Color(255, 255, 255));

        btn_exit.setText("Hủy");
        btn_exit.setBackground(new java.awt.Color(244, 67, 54));
        btn_exit.setForeground(new java.awt.Color(255, 255, 255));

        btn_addItem.setText("Thêm sách");
        btn_addItem.setBackground(new java.awt.Color(88, 175, 232));
        btn_addItem.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_bottomLayout = new javax.swing.GroupLayout(panel_bottom);
        panel_bottom.setLayout(panel_bottomLayout);
        panel_bottomLayout.setHorizontalGroup(
            panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_addItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_bottomLayout.setVerticalGroup(
            panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
        panel_main.setLayout(panel_mainLayout);
        panel_mainLayout.setHorizontalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollPane)
            .addComponent(panel_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_mainLayout.setVerticalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addComponent(panel_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panel_main, java.awt.BorderLayout.CENTER);

        pack();
    }

    // Variables declaration
    private javax.swing.JButton btn_addItem;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_staff;
    private javax.swing.JLabel label_status;
    private javax.swing.JLabel label_supplier;
    private javax.swing.JPanel panel_bottom;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_top;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table_items;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_purchaseDate;
    private javax.swing.JTextField txt_staff;
    private javax.swing.JTextField txt_status;
    private javax.swing.JTextField txt_supplier;
    // End of variables declaration
}