/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BorrowTicketDAO;
import DTO.BorrowTicketDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class BorrowTicketBUS {
    private final BorrowTicketDAO borrowTicketDAO = new BorrowTicketDAO();
    
    public ArrayList<BorrowTicketDTO> getAll() {
        return borrowTicketDAO.getAll();
    }
    
    public BorrowTicketDTO getById(String id) {
        return borrowTicketDAO.getById(id);
    }
    
}
