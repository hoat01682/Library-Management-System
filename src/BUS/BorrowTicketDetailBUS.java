/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BorrowTicketDetailDAO;
import DTO.BorrowTicketDetailDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class BorrowTicketDetailBUS {
    
    private final BorrowTicketDetailDAO borrowTicketDetailDAO = new BorrowTicketDetailDAO();
    
    public ArrayList<BorrowTicketDetailDTO> getByBorrowTicketDAO(int id) {
        return borrowTicketDetailDAO.getByBorrowTicketId(id);
    }
    
}
