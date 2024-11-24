 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author hieun
 */
public class PurchaseTicketDTO {
    private int id;
    private int supplier_id;
    private int staff_id;
    private Timestamp purchase_date;
    private String status;
    
    public PurchaseTicketDTO(int supplier_id, int staff_id, Timestamp purchase_date, String status) {
        this.supplier_id = supplier_id;
        this.staff_id = staff_id;
        this.purchase_date = purchase_date;
        this.status = status;
    }

    public PurchaseTicketDTO(int id, int supplier_id, int staff_id, Timestamp purchase_date, String status) {
        this.id = id;
        this.supplier_id = supplier_id;
        this.staff_id = staff_id;
        this.purchase_date = purchase_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public Timestamp getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Timestamp purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
