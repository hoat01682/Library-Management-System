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
    private String purchaseticket_id;
    private int bookshelf_id;
    private String status;

    public BookItemDTO(String isbn, int bookId, String purchaseticket_id, int bookshelf_id, String status) {
        this.isbn = isbn;
        this.book_id = bookId;
        this.purchaseticket_id = purchaseticket_id;
        this.bookshelf_id = bookshelf_id;
        this.status = status;
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

    public void setBook_id(int bookId) {
        this.book_id = bookId;
    }

    public String getPurchaseticket_id() {
        return purchaseticket_id;
    }

    public void setPurchaseticket_id(String purchaseticket_id) {
        this.purchaseticket_id = purchaseticket_id;
    }

    public int getBookshelf_id() {
        return bookshelf_id;
    }

    public void setBookshelf_id(int bookshelf_id) {
        this.bookshelf_id = bookshelf_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
