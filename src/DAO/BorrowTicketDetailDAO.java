/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.BorrowTicketDetailDTO;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class BorrowTicketDetailDAO {
    
    public static BorrowTicketDetailDAO getInstance() {
        return new BorrowTicketDetailDAO();
    }
    
    public ArrayList<BorrowTicketDetailDTO> getByBorrowTicketId(int id) {
        ArrayList<BorrowTicketDetailDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM borrowticket_details WHERE borrow_ticket_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int borrow_ticket_details_id = rs.getInt("borrow_ticket_details_id");
                int borrow_ticket_id = rs.getInt("borrow_ticket_id");
                String isbn = rs.getString("isbn");
                String status = rs.getString("status");

                BorrowTicketDetailDTO borrowticket_detail = new BorrowTicketDetailDTO(borrow_ticket_details_id, borrow_ticket_id, isbn, status);

                list.add(borrowticket_detail);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public int borrowBooks(ArrayList<BorrowTicketDetailDTO> list) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();

            for (BorrowTicketDetailDTO i : list) {
                String query = "INSERT INTO borrowticket_details (borrow_ticket_id, isbn, status) VALUES (?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(query);
                
                ps.setInt(1, i.getBorrow_ticket_id());
                ps.setString(2, i.getIsbn());
                ps.setString(3, i.getStatus());
                result = ps.executeUpdate();
                
                BookItemDAO.getInstance().changeStatus(BookItemDAO.getInstance().getByISBN(i.getIsbn()), "Đang mượn");
            }

            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
}
