/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ReturnTicketDetailsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ReturnTicketDetailsDAO {   
    private Connection connection;

    public ReturnTicketDetailsDAO(Connection connection) {
        this.connection = connection;
    }
    //Lấy mảng chi tiết phiếu trả theo id
    public List<ReturnTicketDetailsDTO> getReturnDetailsbyID(String id) throws SQLException {
        List<ReturnTicketDetailsDTO> returnTicketDetails = new ArrayList<>();
        String query = "SELECT " 
                 + "FROM returnticket_details "
                 + "where return_ticket_details_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            stmt.setString(1, id);
            while (rs.next()) {
                ReturnTicketDetailsDTO detail = new ReturnTicketDetailsDTO();
                detail.setreturnTicketdetailsId(rs.getInt("return_ticket_details_id"));
                detail.setreturnTicketId(rs.getString("return_ticket_id"));
                detail.setIsbn(rs.getString("isbn"));
                returnTicketDetails.add(detail);
            }
        }
        return returnTicketDetails;
    }
    
    //Lấy mảng chi tiết phiếu trả 
    public List<ReturnTicketDetailsDTO> getAllReturnDetails() throws SQLException {
        List<ReturnTicketDetailsDTO> returnTicketDetails = new ArrayList<>();
        String query = "SELECT * " 
                 + "FROM returnticket_details";
        try (PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ReturnTicketDetailsDTO detail = new ReturnTicketDetailsDTO();
                detail.setreturnTicketdetailsId(rs.getInt("return_ticket_details_id"));
                detail.setreturnTicketId(rs.getString("return_ticket_id"));
                detail.setIsbn(rs.getString("isbn"));
                returnTicketDetails.add(detail);
            }
        }
        return returnTicketDetails;
    }
    
    //Thêm chi tiết phiếu trả
    public boolean addReturnDetails(ReturnTicketDetailsDTO detail) {
        boolean result = false;
        String query = "INSERT INTO returnticket_details (return_ticket_id, isbn) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
                stmt.setString(1, detail.getreturnTicketId());
                stmt.setString(2, detail.getIsbn());
                if(stmt.executeUpdate()>0) {
                    result=true;
                }

            }catch (SQLException e) {
            System.out.println(e);
        }    
            return result;
    }
    
}