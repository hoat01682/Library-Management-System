/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PurchaseTicketDetailDTO;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hieun
 */
public class PurchaseTicketDetailDAO {

    public int add(PurchaseTicketDetailDTO purchaseTicketDetail) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();

            String query = "INSERT INTO purchaseticket_details (purchase_ticket_id, book_id, quantity, price, total_price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, purchaseTicketDetail.getPurchaseTicket_id());
            ps.setInt(2, purchaseTicketDetail.getBook_id());
            ps.setInt(3, purchaseTicketDetail.getQuantity());
            ps.setLong(4, purchaseTicketDetail.getPrice());
            ps.setLong(5, purchaseTicketDetail.getTotal_price());

            result = ps.executeUpdate();

            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
    public int addList(ArrayList<PurchaseTicketDetailDTO> list) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();

            for (PurchaseTicketDetailDTO i : list) {
                String query = "INSERT INTO purchaseticket_details (purchase_ticket_id, book_id, quantity, price, total_price) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(query);

                ps.setInt(1, i.getPurchaseTicket_id());
                ps.setInt(2, i.getBook_id());
                ps.setInt(3, i.getQuantity());
                ps.setLong(4, i.getPrice());
                ps.setLong(5, i.getTotal_price());

                result = ps.executeUpdate();
                
                BookDAO.getInstance().increaseQuantity(i.getBook_id(), i.getQuantity());
            }

            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    public ArrayList<PurchaseTicketDetailDTO> getByPurchaseTicketId(int purchaseTicket_id) {
        ArrayList<PurchaseTicketDetailDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM purchaseticket_details WHERE purchase_ticket_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, purchaseTicket_id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("purchase_ticket_details_id");
                int purchase_ticket_id = rs.getInt("purchase_ticket_id");
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                long price = rs.getLong("price");
                long total_price = rs.getLong("total_price");

                PurchaseTicketDetailDTO purchaseTicketDetail = new PurchaseTicketDetailDTO(id, purchase_ticket_id, book_id, quantity, price, total_price);

                list.add(purchaseTicketDetail);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
}
