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
    
    public static BorrowTicketDAO getInstance() {
        return new BorrowTicketDAO();
    }
    
    public ArrayList<BorrowTicketDTO> getAll() {
        ArrayList<BorrowTicketDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM `borrowticket`";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("borrow_ticket_id");
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
    
    public BorrowTicketDTO getById(int id) {
        BorrowTicketDTO borrowTicket = null;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "SELECT * FROM `borrowticket` WHERE borrow_ticket_id = ?";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id); 
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int borrow_ticket_id = rs.getInt("borrow_ticket_id");
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
    
    public ArrayList<BorrowTicketDTO> getByMemberID(int memberID) {
        ArrayList<BorrowTicketDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM `borrowticket` WHERE member_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, memberID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("borrow_ticket_id");
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
    
    public int add(BorrowTicketDTO borrowTicket) {
        int result = 0;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "INSERT INTO borrowticket (staff_id, member_id, borrow_date, due_date, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, borrowTicket.getStaff_id());
            ps.setInt(2, borrowTicket.getMember_id());
            ps.setTimestamp(3, borrowTicket.getBorrow_date());
            ps.setTimestamp(4, borrowTicket.getDue_date());
            ps.setString(5, borrowTicket.getStatus());
            
            result = ps.executeUpdate();
            
            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public int getLastID() {
        int result = 0;
        
        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM `borrowticket` ORDER BY `borrow_ticket_id` DESC LIMIT 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                result = rs.getInt("borrow_ticket_id");
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
}
