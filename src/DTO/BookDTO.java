/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hieun
 */
public class BookDTO {
    private int id;
    private String title;
    private String author;
    private int publisherId;
    private int yearPublish;
    private int categoryId;
    private int quantity;
    private String image;
    private int bookshelf_id;
    
    public BookDTO(String title, String author, int publisherId, int yearPublish, int categoryId, int quantity, String image, int bookshelf_id) {
        this.title = title;
        this.author = author;
        this.publisherId = publisherId;
        this.yearPublish = yearPublish;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.image = image;
        this.bookshelf_id = bookshelf_id;
    }

    public BookDTO(int id, String title, String author, int publisherId, int yearPublish, int categoryId, int quantity, String image, int bookshelf_id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisherId = publisherId;
        this.yearPublish = yearPublish;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.image = image;
        this.bookshelf_id = bookshelf_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBookshelf_id() {
        return bookshelf_id;
    }

    public void setBookshelf_id(int bookshelf_id) {
        this.bookshelf_id = bookshelf_id;
    }

}
