/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BookItemDAO;
import DAO.PurchaseTicketDAO;
import DAO.PurchaseTicketDetailDAO;
import DTO.BookItemDTO;
import DTO.PurchaseTicketDTO;
import DTO.PurchaseTicketDetailDTO;
import java.util.ArrayList;

/**
 *
 * @author hieun
 */
public class PurchaseTicketBUS {

    private final PurchaseTicketDAO purchaseTicketDAO = new PurchaseTicketDAO();
    private final PurchaseTicketDetailDAO detailDAO = new PurchaseTicketDetailDAO();
    private final BookItemDAO bookItemDAO = new BookItemDAO();

    public boolean addPurchaseTicket(PurchaseTicketDTO purchaseTicket) {
        return purchaseTicketDAO.add(purchaseTicket) > 0;
    }
    
    public boolean addWithLists(PurchaseTicketDTO purchaseTicket, ArrayList<PurchaseTicketDetailDTO> detailList, ArrayList<BookItemDTO> bookItemList) {
        if(purchaseTicketDAO.add(purchaseTicket) != 0) {
            detailDAO.addList(detailList);
            bookItemDAO.addList(bookItemList);
            return true;
        }
        return false;
    }
    
    public ArrayList<PurchaseTicketDTO> getAllPurchaseTicket() {
        return purchaseTicketDAO.getAll();
    }
    
    public PurchaseTicketDTO getById(int id) {
        return purchaseTicketDAO.getById(id);
    }
    
    public int getLastID() {
        return purchaseTicketDAO.getLastID();
    }
    
}
