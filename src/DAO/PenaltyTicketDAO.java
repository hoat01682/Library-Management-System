
package DAO;

import config.Database;
import DTO.PenaltyTicketDTO;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PenaltyTicketDAO {

    // Add PenaltyTicket
    public int add(PenaltyTicketDTO penaltyTicket) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();

            String query = "INSERT INTO penaltyticket (member_id, staff_id, penalty_id, penalty_date, note, return_ticket_id, fine) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, penaltyTicket.getMember_id());
            ps.setInt(2, penaltyTicket.getStaff_id());
            ps.setInt(3, penaltyTicket.getPenalty_id());
            ps.setTimestamp(4, penaltyTicket.getPenalty_date());
            ps.setString(5, penaltyTicket.getNote());
            ps.setInt(6, penaltyTicket.getReturnTicket_id());
            ps.setInt(7, penaltyTicket.getFine());
            
            result = ps.executeUpdate();

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    // Remove PenaltyTicket by Id
    public int remove(PenaltyTicketDTO penaltyTicket) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();

            String query = "DELETE FROM penaltyticket WHERE penalty_ticket_id = ?";
            
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, penaltyTicket.getId());

            result = ps.executeUpdate();

            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    // Update PenaltyTicket by Id
    public int update(PenaltyTicketDTO penaltyTicket) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();

            String query = "UPDATE penaltyticket SET member_id = ?, staff_id = ?, penalty_id = ?, penalty_date = ?, note = ?, return_ticket_id = ?, fine = ? WHERE penalty_ticket_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, penaltyTicket.getMember_id());
            ps.setInt(2, penaltyTicket.getStaff_id());
            ps.setInt(3, penaltyTicket.getPenalty_id());
            ps.setTimestamp(4, penaltyTicket.getPenalty_date());
            ps.setString(5, penaltyTicket.getNote());
            ps.setInt(6, penaltyTicket.getReturnTicket_id());
            ps.setInt(7, penaltyTicket.getFine());
            ps.setInt(8, penaltyTicket.getId());

            result = ps.executeUpdate();

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    // Reset PenaltyTicket
    public ArrayList<PenaltyTicketDTO> reset() {
        ArrayList<PenaltyTicketDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM penaltyticket";
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("penalty_ticket_id");
                int member_id = rs.getInt("member_id");
                int staff_id = rs.getInt("staff_id");
                int penalty_id = rs.getInt("penalty_id");
                Timestamp penalty_date = rs.getTimestamp("penalty_date");
                String note = rs.getString("note");
                int returnTicket_id = rs.getInt("return_ticket_id");
                int fine = rs.getInt("fine");

                PenaltyTicketDTO penaltyTicket = new PenaltyTicketDTO(id, member_id, staff_id, penalty_id, penalty_date, note, returnTicket_id, fine);

                list.add(penaltyTicket);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    // Filter by date
    public ArrayList<PenaltyTicketDTO> filterDate(String startDate, String endDate) {
        ArrayList<PenaltyTicketDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM penaltyticket WHERE penalty_date >= ? AND penalty_date <= ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, startDate);
            ps.setString(2, endDate);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("penalty_ticket_id");
                int member_id = rs.getInt("member_id");
                int staff_id = rs.getInt("staff_id");
                int penalty_id = rs.getInt("penalty_id");
                Timestamp penalty_date = rs.getTimestamp("penalty_date");
                String note = rs.getString("note");
                int returnTicket_id = rs.getInt("return_ticket_id");
                int fine = rs.getInt("fine");

                PenaltyTicketDTO penaltyTicket = new PenaltyTicketDTO(id, member_id, staff_id, penalty_id, penalty_date, note, returnTicket_id, fine);
                
                list.add(penaltyTicket);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    // Filter by dynamic properties
    public ArrayList<PenaltyTicketDTO> filterDynamic(int type, int id) {
    ArrayList<PenaltyTicketDTO> list = new ArrayList<>();

    try {
        Connection connection = Database.getConnection();

        String query = "SELECT * FROM penaltyticket WHERE ? = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, type);
        ps.setInt(2, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id1 = rs.getInt("penalty_ticket_id");
            int member_id = rs.getInt("member_id");
            int staff_id = rs.getInt("staff_id");
            int penalty_id = rs.getInt("penalty_id");
            Timestamp penalty_date = rs.getTimestamp("penalty_date");
            String note = rs.getString("note");
            int returnTicket_id = rs.getInt("return_ticket_id");
            int fine = rs.getInt("fine");

            PenaltyTicketDTO penaltyTicket = new PenaltyTicketDTO(id1, member_id, staff_id, penalty_id, penalty_date, note, returnTicket_id, fine);

            list.add(penaltyTicket); // Correct the variable name to penaltyTicket
        }

        Database.closeConnection(connection);

    } catch (SQLException e) {
        System.out.println(e);
    }

    return list;
}
}