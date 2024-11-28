/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ReturnTicketDetailDTO;
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
public class ReturnTicketDetailDAO {
    
    public ArrayList<ReturnTicketDetailDTO> getByReturnTicketId(int id) {
        ArrayList<ReturnTicketDetailDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM returnticket_details WHERE return_ticket_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id1 = rs.getInt("return_ticket_details_id");
                int returnTicket_id = rs.getInt("return_ticket_id");
                int borrowticket_id = rs.getInt("borrow_ticket_id");
                String isbn = rs.getString("isbn");
                String status = rs.getString("status");
                

                ReturnTicketDetailDTO returnticket_detail = new ReturnTicketDetailDTO(id1, returnTicket_id, borrowticket_id, isbn, status);

                list.add(returnticket_detail);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public int returnBooks(ArrayList<ReturnTicketDetailDTO> list) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();

            for (ReturnTicketDetailDTO i : list) {
                String query = "INSERT INTO returnticket_details (return_ticket_id, borrow_ticket_id, isbn, status) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(query);
                
                ps.setInt(1, i.getReturnTicket_id());
                ps.setInt(2, i.getBorrow_ticket_id());
                ps.setString(3, i.getIsbn());
                ps.setString(4, i.getStatus());
                result = ps.executeUpdate();
                
                BookItemDAO.getInstance().changeStatus(BookItemDAO.getInstance().getByISBN(i.getIsbn()), "Có sẵn");
            }

            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
}