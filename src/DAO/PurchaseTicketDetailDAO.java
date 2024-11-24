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

            String query = "INSERT INTO purchaseticket_details (purchase_ticket_id, isbn, book_id, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, purchaseTicketDetail.getPurchaseTicket_id());
            ps.setString(2, purchaseTicketDetail.getIsbn());
            ps.setInt(3, purchaseTicketDetail.getBook_id());
            ps.setInt(4, purchaseTicketDetail.getQuantity());

            result = ps.executeUpdate();

            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    public ArrayList<PurchaseTicketDetailDTO> getByPurchaseTicketId(String purchaseTicket_id) {
        ArrayList<PurchaseTicketDetailDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM purchaseticket_details WHERE purchase_ticket_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, purchaseTicket_id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int purchase_ticket_details_id = rs.getInt("purchase_ticket_details_id");
                int purchase_ticket_id = rs.getInt("purchase_ticket_id");
                String isbn = rs.getString("isbn");
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");

                PurchaseTicketDetailDTO purchaseTicketDetail = new PurchaseTicketDetailDTO(purchase_ticket_details_id, purchase_ticket_id, isbn, book_id, quantity);

                list.add(purchaseTicketDetail);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
}
