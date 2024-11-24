/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ReturnTicketDAO;
import DTO.ReturnTicketDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class ReturnTicketBUS {
    
    private final ReturnTicketDAO returnTicketDAO = new ReturnTicketDAO();
    
    public ArrayList<ReturnTicketDTO> getAll() {
        return returnTicketDAO.getAll();
    }
    
}
