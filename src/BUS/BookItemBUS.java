/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BookItemDAO;
import DTO.BookItemDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class BookItemBUS {
    
    private final BookItemDAO bookItemDAO = new BookItemDAO();
    
    public ArrayList<BookItemDTO> getByBookId(int id) {
        return bookItemDAO.getByBookId(id);
    }
    
}
