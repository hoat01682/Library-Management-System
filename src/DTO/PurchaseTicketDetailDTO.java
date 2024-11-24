/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hieun
 */
public class PurchaseTicketDetailDTO {
    private int purchaseTicketDetail_id;
    private int purchaseTicket_id;
    private String isbn;
    private int book_id;
    private int quantity;

    public PurchaseTicketDetailDTO(int purchaseTicket_id, String isbn, int book_id, int quantity) {
        this.purchaseTicket_id = purchaseTicket_id;
        this.isbn = isbn;
        this.book_id = book_id;
        this.quantity = quantity;
    }

    public PurchaseTicketDetailDTO(int purchaseTicketDetail_id, int purchaseTicket_id, String isbn, int book_id, int quantity) {
        this.purchaseTicketDetail_id = purchaseTicketDetail_id;
        this.purchaseTicket_id = purchaseTicket_id;
        this.isbn = isbn;
        this.book_id = book_id;
        this.quantity = quantity;
    }

    public int getPurchaseTicketDetail_id() {
        return purchaseTicketDetail_id;
    }

    public void setPurchaseTicketDetail_id(int purchaseTicketDetail_id) {
        this.purchaseTicketDetail_id = purchaseTicketDetail_id;
    }

    public int getPurchaseTicket_id() {
        return purchaseTicket_id;
    }

    public void setPurchaseTicket_id(int purchaseTicket_id) {
        this.purchaseTicket_id = purchaseTicket_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
