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
    String borrow_ticket_id;
    String isbn;

    public BorrowTicketDetailDTO(int id, String borrow_ticket_id, String isbn) {
        this.id = id;
        this.borrow_ticket_id = borrow_ticket_id;
        this.isbn = isbn;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrow_ticket_id() {
        return borrow_ticket_id;
    }

    public void setBorrow_ticket_id(String borrow_ticket_id) {
        this.borrow_ticket_id = borrow_ticket_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
}
