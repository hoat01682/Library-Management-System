package BUS;

import DAO.ReturnTicketDetailsDAO;
import DTO.ReturnTicketDetailsDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReturnTicketDetailsBUS {
    private ReturnTicketDetailsDAO returnTicketDetailsDAO;

    // Constructor, truyền đối tượng DAO
    public ReturnTicketDetailsBUS(ReturnTicketDetailsDAO returnTicketDetailsDAO) {
        this.returnTicketDetailsDAO = returnTicketDetailsDAO;
    }

    // Lấy tất cả chi tiết phiếu trả
    public List<ReturnTicketDetailsDTO> getAllReturnDetails() {
        try {
            return returnTicketDetailsDAO.getAllReturnDetails();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Lấy chi tiết phiếu trả theo ID của phiếu trả
    public List<ReturnTicketDetailsDTO> getReturnDetailsbyID(String returnTicketId) {
        try {
            return returnTicketDetailsDAO.getReturnDetailsbyID(returnTicketId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Thêm chi tiết phiếu trả
    public boolean addDetails(ReturnTicketDetailsDTO returnTicketDetails) {
        return returnTicketDetailsDAO.addReturnDetails(returnTicketDetails);
    }

}
