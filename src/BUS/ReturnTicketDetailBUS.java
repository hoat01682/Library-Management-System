/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ReturnTicketDetailDAO;
import DTO.ReturnTicketDetailDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class ReturnTicketDetailBUS {
    
    private final ReturnTicketDetailDAO returnTicketDetailDAO = new ReturnTicketDetailDAO();
    
    public ArrayList<ReturnTicketDetailDTO> getByReturnTicketId(int id) {
        return returnTicketDetailDAO.getByReturnTicketId(id);
    }
    
}
