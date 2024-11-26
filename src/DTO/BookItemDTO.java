/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duc3m
 */
public class BookItemDTO {
    private String isbn;
    private int book_id;
    private int purchaseticket_id;
    private String status;
    private long price;

    public BookItemDTO(String isbn, int book_id, int purchaseticket_id, String status, long price) {
        this.isbn = isbn;
        this.book_id = book_id;
        this.purchaseticket_id = purchaseticket_id;
        this.status = status;
        this.price = price;
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

    public int getPurchaseticket_id() {
        return purchaseticket_id;
    }

    public void setPurchaseticket_id(int purchaseticket_id) {
        this.purchaseticket_id = purchaseticket_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookItemDTO{" + "isbn=" + isbn + ", book_id=" + book_id + ", purchaseticket_id=" + purchaseticket_id + ", status=" + status + ", price=" + price + '}';
    }

}
