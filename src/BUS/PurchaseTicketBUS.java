/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PurchaseTicketDAO;
import DTO.PurchaseTicketDTO;
import java.util.ArrayList;

/**
 *
 * @author hieun
 */
public class PurchaseTicketBUS {

    private final PurchaseTicketDAO purchaseTicketDAO = new PurchaseTicketDAO();

    public boolean addPurchaseTicket(PurchaseTicketDTO purchaseTicket) {
        return purchaseTicketDAO.add(purchaseTicket) > 0;
    }

    public boolean updateStatus(String id) {
        return purchaseTicketDAO.updateStatus(id) > 0;
    }
    
    public ArrayList<PurchaseTicketDTO> getAllPurchaseTicket() {
        return purchaseTicketDAO.getAll();
    }
}
