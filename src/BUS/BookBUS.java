package BUS;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import DAO.BookDAO;
import DTO.BookDTO;
import java.util.ArrayList;

/**
 *
 * @author hieun
 */
public class BookBUS {
    private final BookDAO bookDAO = new BookDAO();
    
    public boolean addBook(BookDTO book) {
        return bookDAO.add(book) > 0;
    }
    
    public boolean updateBook(BookDTO book) {
        return bookDAO.update(book) > 0;
    }
    
    public ArrayList<BookDTO> getAllBook() {
        return bookDAO.getAll();
    }
    
    public BookDTO getById(String id) {
        return bookDAO.getById(id);
    }
    
}
