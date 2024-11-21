/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PurchaseTicketDTO;
import config.Database;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hieun
 */
public class PurchaseTicketDAO {
    public int add(PurchaseTicketDTO purchaseTicket) {
        int result = 0;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "INSERT INTO purchaseticket (purchase_ticket_id, supplier_id, staff_id, purchase_date, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, purchaseTicket.getId());
            ps.setInt(2, purchaseTicket.getSupplier_id());
            ps.setInt(3, purchaseTicket.getStaff_id());
            ps.setString(4, purchaseTicket.getPurchase_date());
            ps.setString(5, purchaseTicket.getStatus());
            
            result = ps.executeUpdate();
            
            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public int updateStatus(String id) {
        int result = 0;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "UPDATE purchaseticket SET status = 'Hủy'";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            result = ps.executeUpdate();
            
            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public ArrayList<PurchaseTicketDTO> getAll() {
        ArrayList<PurchaseTicketDTO> list = new ArrayList<>();
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "SELECT * FROM purchaseticket";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                String purchase_ticket_id = rs.getString("purchase_ticket_id");
                int supplier_id = rs.getInt("supplier_id");
                int staff_id = rs.getInt("staff_id");
                String purchase_date = rs.getString("purchase_date");
                String status = rs.getString("status");
                
                PurchaseTicketDTO purchaseTicket = new PurchaseTicketDTO(purchase_ticket_id, supplier_id, staff_id, purchase_date, status);
                
                list.add(purchaseTicket);
            }
            
            Database.closeConnection(connection);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
}
