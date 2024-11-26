/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BorrowTicketDAO;
import DAO.BorrowTicketDetailDAO;
import DTO.BorrowTicketDTO;
import DTO.BorrowTicketDetailDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class BorrowTicketBUS {
    private final BorrowTicketDAO borrowTicketDAO = new BorrowTicketDAO();
    private final BorrowTicketDetailDAO detailDAO = new BorrowTicketDetailDAO();
    
    public static BorrowTicketBUS getInstance() {
        return new BorrowTicketBUS();
    }   
    
    public int getLastID() {
        return borrowTicketDAO.getLastID();
    }
    
    public ArrayList<BorrowTicketDTO> getAll() {
        return borrowTicketDAO.getAll();
    }
    
    public BorrowTicketDTO getById(int id) {
        return borrowTicketDAO.getById(id);
    }
    
    public boolean addWithDetail(BorrowTicketDTO borrowTicket, ArrayList<BorrowTicketDetailDTO> detailList) {
        if(borrowTicketDAO.add(borrowTicket) != 0) {
            detailDAO.borrowBooks(detailList);
            return true;
        }
        return false;
    }
    
}
