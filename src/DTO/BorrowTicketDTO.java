/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author Duc3m
 */
public class BorrowTicketDTO {
    
    private int id;
    private int staff_id;
    private int member_id;
    private Timestamp borrow_date;
    private Timestamp due_date;
    private String status;

    public BorrowTicketDTO(int staff_id, int member_id, Timestamp borrow_date, Timestamp due_date, String status) {
        this.staff_id = staff_id;
        this.member_id = member_id;
        this.borrow_date = borrow_date;
        this.due_date = due_date;
        this.status = status;
    }

    public BorrowTicketDTO(int id, int staff_id, int member_id, Timestamp borrow_date, Timestamp due_date, String status) {
        this.id = id;
        this.staff_id = staff_id;
        this.member_id = member_id;
        this.borrow_date = borrow_date;
        this.due_date = due_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public Timestamp getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Timestamp borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Timestamp getDue_date() {
        return due_date;
    }

    public void setDue_date(Timestamp due_date) {
        this.due_date = due_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
