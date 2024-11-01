package BUS;

import DAO.ReturnTicketDAO;
import DTO.ReturnTicketDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReturnTicketBUS {
    private ReturnTicketDAO returnTicketDAO;

    public ReturnTicketBUS(Connection connection) {
        this.returnTicketDAO = new ReturnTicketDAO(connection);
    }

    public List<ReturnTicketDTO> getAllReturnTickets() {
        try {
            return returnTicketDAO.getAllReturnTickets();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ReturnTicketDTO getReturnTicketById(String returnTicketId) {
        try {
            return returnTicketDAO.getReturnTicketById(returnTicketId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addReturnTicket(ReturnTicketDTO ticket) {
        try {
            returnTicketDAO.addReturnTicket(ticket);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStatusReturnTicket(String returnTicketId) {
        try {
            returnTicketDAO.updateStatusReturnTicket(returnTicketId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Add more methods to interact with the DAO as needed
}