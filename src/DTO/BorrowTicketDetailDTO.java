/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duc3m
 */
public class BorrowTicketDetailDTO {
    
    int id;
    int borrow_ticket_id;
    String isbn;
    String status;

    public BorrowTicketDetailDTO(int borrow_ticket_id, String isbn, String status) {
        this.borrow_ticket_id = borrow_ticket_id;
        this.isbn = isbn;
        this.status = status;
    }

    public BorrowTicketDetailDTO(int id, int borrow_ticket_id, String isbn, String status) {
        this.id = id;
        this.borrow_ticket_id = borrow_ticket_id;
        this.isbn = isbn;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorrow_ticket_id() {
        return borrow_ticket_id;
    }

    public void setBorrow_ticket_id(int borrow_ticket_id) {
        this.borrow_ticket_id = borrow_ticket_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
