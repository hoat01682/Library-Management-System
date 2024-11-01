package DAO;

import DTO.ReturnTicketDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReturnTicketDAO {
    private Connection connection;

    public ReturnTicketDAO(Connection connection) {
        this.connection = connection;
    }
        // Lấy mảng phiếu đặt
    public List<ReturnTicketDTO> getAllReturnTickets() throws SQLException {
        List<ReturnTicketDTO> returnTickets = new ArrayList<>();
        String query = "SELECT * FROM returnticket";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ReturnTicketDTO ticket = new ReturnTicketDTO();
                ticket.setReturnTicketId(rs.getString("return_ticket_id"));
                ticket.setBorrowTicketId(rs.getString("borrow_ticket_id"));
                ticket.setStaffId(rs.getInt("staff_id"));
                ticket.setReturnDate(rs.getString("return_date"));
                ticket.setStatus(rs.getString("status"));
                returnTickets.add(ticket);
            }
        }
        return returnTickets;
    }
        
    // Lấy mảng phiếu đặt theo id
    public ReturnTicketDTO getReturnTicketById(String returnTicketId) throws SQLException {
        String query = "SELECT * FROM returnticket WHERE return_ticket_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, returnTicketId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ReturnTicketDTO ticket = new ReturnTicketDTO();
                    ticket.setReturnTicketId(rs.getString("return_ticket_id"));
                    ticket.setBorrowTicketId(rs.getString("borrow_ticket_id"));
                    ticket.setStaffId(rs.getInt("staff_id"));
                    ticket.setReturnDate(rs.getString("return_date"));
                    ticket.setStatus(rs.getString("status"));
                    return ticket;
                }
            }
        }
        return null;
    }
        //Thêm phiếu trả
    public void addReturnTicket(ReturnTicketDTO ticket) throws SQLException {
        String query = "INSERT INTO returnticket (return_ticket_id, borrow_ticket_id, staff_id, return_date, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ticket.getReturnTicketId());
            stmt.setString(2, ticket.getBorrowTicketId());
            stmt.setInt(3, ticket.getStaffId());
            stmt.setString(4, ticket.getReturnDate());
            stmt.setString(5, "Hoàn thành"); //Chuyển trạng thái thành "Hoàn thành"
            stmt.executeUpdate();
        }
    }
    
        //Hủy phiếu trả (cập nhật trạng thái hủy)
    public void updateStatusReturnTicket(String returnTicketId) throws SQLException {
        // Cập nhật trạng thái bookitem
        String updateBookitemQuery = "UPDATE bookitem bi " +
                                     "JOIN returnticket_details rtd ON bi.bookitem_id = rtd.book_item_id " +
                                     "JOIN returnticket rt ON rtd.return_ticket_id = rt.return_ticket_id " +
                                     "SET bi.status = 'Đang cho mượn' " +
                                     "WHERE rt.return_ticket_id = ?";

        // Cập nhật trạng thái borrowticket
        String updateBorrowTicketQuery = "UPDATE borrowticket bt " +
                                         "JOIN returnticket rt ON bt.borrow_ticket_id = rt.borrow_ticket_id " +
                                         "SET bt.status = 'Chưa trả' " +
                                         "WHERE rt.return_ticket_id = ?";

        // Cập nhật trạng thái returnticket
        String updateReturnTicketQuery = "UPDATE returnticket " +
                                         "SET status = 'Đã hủy' " +
                                         "WHERE return_ticket_id = ?";
        try {
            // Mở phiên giao dịch
            connection.setAutoCommit(false);

            // Cập nhật trạng thái bookitem
            try (PreparedStatement stmt = connection.prepareStatement(updateBookitemQuery)) {
                stmt.setString(1, returnTicketId);
                stmt.executeUpdate();
            }

            // Cập nhật trạng thái borrowticket
            try (PreparedStatement stmt = connection.prepareStatement(updateBorrowTicketQuery)) {
                stmt.setString(1, returnTicketId);
                stmt.executeUpdate();
            }

            // Cập nhật trạng thái returnticket
            try (PreparedStatement stmt = connection.prepareStatement(updateReturnTicketQuery)) {
                stmt.setString(1, returnTicketId);
                stmt.executeUpdate();
            }

            // Cam kết thay đổi
            connection.commit();

        } catch (SQLException e) {
            // Nếu có lỗi, hủy bỏ các thay đổi
            connection.rollback();
            throw e;
        } finally {
            // Đặt lại chế độ tự động commit
            connection.setAutoCommit(true);
        }
    }   
}