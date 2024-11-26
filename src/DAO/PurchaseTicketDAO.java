/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PurchaseTicketDTO;
import config.Database;
import java.sql.Timestamp;
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
            
            String query = "INSERT INTO purchaseticket (supplier_id, staff_id, purchase_date, status, total_price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, purchaseTicket.getSupplier_id());
            ps.setInt(2, purchaseTicket.getStaff_id());
            ps.setTimestamp(3, purchaseTicket.getPurchase_date());
            ps.setString(4, purchaseTicket.getStatus());
            ps.setLong(5, purchaseTicket.getTotal_price());
            
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
                int purchase_ticket_id = rs.getInt("purchase_ticket_id");
                int supplier_id = rs.getInt("supplier_id");
                int staff_id = rs.getInt("staff_id");
                Timestamp purchase_date = rs.getTimestamp("purchase_date");
                String status = rs.getString("status");
                long total_price = rs.getLong("total_price");
                
                PurchaseTicketDTO purchaseTicket = new PurchaseTicketDTO(purchase_ticket_id, supplier_id, staff_id, purchase_date, status, total_price);
                
                list.add(purchaseTicket);
            }
            
            Database.closeConnection(connection);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public PurchaseTicketDTO getById(int id) {
        PurchaseTicketDTO purchaseTicket = null;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "SELECT * FROM purchaseticket WHERE purchase_ticket_id = ?";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id); 
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int purchase_ticket_id = rs.getInt("purchase_ticket_id");
                int supplier_id = rs.getInt("supplier_id");
                int staff_id = rs.getInt("staff_id");
                Timestamp purchase_date = rs.getTimestamp("purchase_date");
                String status = rs.getString("status");
                long total_price = rs.getLong("total_price");
                
                purchaseTicket = new PurchaseTicketDTO(purchase_ticket_id, supplier_id, staff_id, purchase_date, status, total_price);
            }
            
            Database.closeConnection(connection); 
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return purchaseTicket;
    }
    
    public int getLastID() {
        int result = 0;
        
        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM `purchaseticket` ORDER BY `purchase_ticket_id` DESC LIMIT 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                result = rs.getInt("purchase_ticket_id");
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
}
