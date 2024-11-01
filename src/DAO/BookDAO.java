package DAO;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import DTO.BookDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hieun
 */
public class BookDAO {
    
    public int add(BookDTO book) {
        int result = 0;
        
        try {
            Connection connection = Database.getConnection();
           
            String query = "INSERT INTO book (book_id, title, author, publisher_id, year_publish, category_id, quantity, book_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getPublisherId());
            ps.setInt(5, book.getYearPublish());
            ps.setInt(6, book.getCategoryId());
            ps.setInt(7, book.getQuantity());
            ps.setString(8, book.getImage());
            result = ps.executeUpdate();
            
            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public int update(BookDTO book) {
        int result = 0;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "UPDATE book SET title = ?, author = ?, publisher_id = ?, year_publish = ?, category_id = ?, quantity = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, book.getTitle()); 
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublisherId());
            ps.setInt(4, book.getYearPublish());
            ps.setInt(5, book.getCategoryId());
            ps.setInt(6, book.getQuantity());
            ps.setString(7, book.getId());
            
            result = ps.executeUpdate();
            
            Database.closeConnection(connection);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public ArrayList<BookDTO> getAll() {
        ArrayList<BookDTO> list = new ArrayList<>();
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "SELECT * FROM book";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                String id = rs.getString("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int publisher_id = rs.getInt("publisher_id");
                int year = rs.getInt("year_publish");
                int category_id = rs.getInt("category_id");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("book_image");
                BookDTO book = new BookDTO(id, title, author, publisher_id, year, category_id, quantity, image);
                list.add(book);
            }
            
            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
}
