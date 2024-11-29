/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BookshelfDAO;
import DTO.BookshelfDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class BookshelfBUS {
    
    private final BookshelfDAO bookshelfDAO = new BookshelfDAO();
    
    public static BookshelfBUS getInstance() {
        return new BookshelfBUS();
    }
    
    public ArrayList<BookshelfDTO> getAll() {
        return bookshelfDAO.getAll();
    }
    
    public BookshelfDTO getById(int id) {
        return bookshelfDAO.getById(id);
    }
    
    public boolean add(BookshelfDTO bookshelf) {
        return bookshelfDAO.add(bookshelf) != 0;
    }
    
    public boolean update(BookshelfDTO bookshelf) {
        return bookshelfDAO.update(bookshelf) != 0;
    }
    
}
