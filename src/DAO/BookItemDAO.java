/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.BookItemDTO;
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
public class BookItemDAO {
    
    public ArrayList<BookItemDTO> getByBookId(int id) {
        ArrayList<BookItemDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM bookitem WHERE book_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String isbn = rs.getString("isbn");
                int book_id = rs.getInt("book_id");
                String purchaseticket_id = rs.getString("purchaseticket_id");
                int bookshelf_id = rs.getInt("bookshelf_id");
                String status = rs.getString("status");
                
                BookItemDTO bookItem = new BookItemDTO(isbn, book_id, purchaseticket_id, bookshelf_id, status);

                list.add(bookItem);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
}
