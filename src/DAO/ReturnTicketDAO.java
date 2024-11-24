/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ReturnTicketDTO;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class ReturnTicketDAO {
    
    public ArrayList<ReturnTicketDTO> getAll() {
        ArrayList<ReturnTicketDTO> list = new ArrayList<>(); 
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "SELECT * FROM returnticket";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("return_ticket_id");
                int borrow_ticket_id = rs.getInt("borrow_ticket_id");
                int staff_id = rs.getInt("staff_id");
                int member_id = rs.getInt("member_id");
                Timestamp return_date = rs.getTimestamp("return_date");
                String status = rs.getString("status");
                
                ReturnTicketDTO returnTicket = new ReturnTicketDTO(id, borrow_ticket_id, staff_id, member_id, return_date, status);
                
                list.add(returnTicket);
            }
            
            Database.closeConnection(connection);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
}
