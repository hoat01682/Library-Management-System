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
    private int id;
    private int purchaseTicket_id;
    private int book_id;
    private int quantity;
    private long price;
    private long total_price;

    public PurchaseTicketDetailDTO(int purchaseTicket_id, int book_id, int quantity, long price, long total_price) {
        this.purchaseTicket_id = purchaseTicket_id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.price = price;
        this.total_price = total_price;
    }

    public PurchaseTicketDetailDTO(int id, int purchaseTicket_id, int book_id, int quantity, long price, long total_price) {
        this.id = id;
        this.purchaseTicket_id = purchaseTicket_id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.price = price;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchaseTicket_id() {
        return purchaseTicket_id;
    }

    public void setPurchaseTicket_id(int purchaseTicket_id) {
        this.purchaseTicket_id = purchaseTicket_id;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "PurchaseTicketDetailDTO{" + "id=" + id + ", purchaseTicket_id=" + purchaseTicket_id + ", book_id=" + book_id + ", quantity=" + quantity + ", price=" + price + ", total_price=" + total_price + '}';
    }
    
}
