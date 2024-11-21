/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PurchaseTicketDetailDAO;
import DTO.PurchaseTicketDetailDTO;
import java.util.ArrayList;

/**
 *
 * @author hieun
 */
public class PurchaseTicketDetailBUS {
    private final PurchaseTicketDetailDAO purchaseTicketDetailDAO = new PurchaseTicketDetailDAO();
    
    public boolean addPurchaseTicketDetail(PurchaseTicketDetailDTO purchaseTicketDetail) {
        return purchaseTicketDetailDAO.add(purchaseTicketDetail) > 0;
    }
    
    public ArrayList<PurchaseTicketDetailDTO> getByPurchaseTicketId(String id) {
        return purchaseTicketDetailDAO.getByPurchaseTicketId(id);
    }
}
