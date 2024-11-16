/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.BorrowTicketDTO;
import config.Database;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class BorrowTicketDAO {
    
    public ArrayList<BorrowTicketDTO> getAll() {
        ArrayList<BorrowTicketDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM `borrowticket`";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("borrow_ticket_id");
                int staff_id = rs.getInt("staff_id");
                int member_id = rs.getInt("member_id");
                Timestamp borrow_date = rs.getTimestamp("borrow_date"); 
                Timestamp due_date = rs.getTimestamp("due_date"); 
                String status = rs.getString("status");

                BorrowTicketDTO borrowTicket = new BorrowTicketDTO(id, staff_id, member_id, borrow_date, due_date, status);

                list.add(borrowTicket);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public BorrowTicketDTO getById(String id) {
        BorrowTicketDTO borrowTicket = null;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "SELECT * FROM `borrowticket` WHERE borrow_ticket_id LIKE ?";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id); 
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String borrow_ticket_id = rs.getString("borrow_ticket_id");
                int staff_id = rs.getInt("staff_id");
                int member_id = rs.getInt("member_id");
                Timestamp borrow_date = rs.getTimestamp("borrow_date"); 
                Timestamp due_date = rs.getTimestamp("due_date"); 
                String status = rs.getString("status");

                borrowTicket = new BorrowTicketDTO(borrow_ticket_id, staff_id, member_id, borrow_date, due_date, status);
            }
            
            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return borrowTicket;
    }
    
}
