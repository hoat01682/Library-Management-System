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
    private String purchaseTicket_id;
    private String isbn;
    private int quantity;

    public PurchaseTicketDetailDTO(int purchaseTicketDetail_id, String purchaseTicket_id, String isbn, int quantity) {
        this.purchaseTicketDetail_id = purchaseTicketDetail_id;
        this.purchaseTicket_id = purchaseTicket_id;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public int getPurchaseTicketDetail_id() {
        return purchaseTicketDetail_id;
    }

    public void setPurchaseTicketDetail_id(int purchaseTicketDetail_id) {
        this.purchaseTicketDetail_id = purchaseTicketDetail_id;
    }

    public String getPurchaseTicket_id() {
        return purchaseTicket_id;
    }

    public void setPurchaseTicket_id(String purchaseTicket_id) {
        this.purchaseTicket_id = purchaseTicket_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
