/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PenaltyTicketDetailDTO;
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
public class PenaltyTicketDetailDAO {
    public ArrayList<PenaltyTicketDetailDTO> getByPenaltyTicketId(int id) {
        ArrayList<PenaltyTicketDetailDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM penaltyticket_detail WHERE penaltyticket_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id1 = rs.getInt("id");
                int penaltyticket_id = rs.getInt("penaltyticket_id");
                int penalty_id = rs.getInt("penalty_id");
                String isbn = rs.getString("isbn");
                int fine = rs.getInt("fine");

                PenaltyTicketDetailDTO returnticket_detail = new PenaltyTicketDetailDTO(id1, penaltyticket_id, penalty_id, isbn, fine);

                list.add(returnticket_detail);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
}
