/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AccountDTO;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hieun
 */
public class AccountDAO {

    public int add(AccountDTO account) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();

            String query = "INSERT INTO account (username, password, role, status) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getRole());
            ps.setInt(4, 1);  

            result = ps.executeUpdate();

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
    public int editStatus(int id, String status) {
        int result = 0;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "UPDATE account SET status = ? WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, status);
            ps.setInt(2, id);
            
            result = ps.executeUpdate();
            
            Database.closeConnection(connection);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }

    public boolean checkLogIn(String username, String password) {
        boolean result = false;

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT username, password FROM account WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password); 

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }

    public boolean searchAccount(String username) {
        boolean result = false;

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT username FROM account WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
    public AccountDTO getByUsername(String username) {
        AccountDTO account = null;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "SELECT * FROM account WHERE username = ?";
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
     
            if (rs.next()) {
                int id = rs.getInt("account_id");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String status = rs.getString("status");
                
                account = new AccountDTO(id, username, password, role, status);
            }
            
            Database.closeConnection(connection);
            
        } catch (SQLException e) {
            System.out.println(e); 
        }
        
        return account;
    }
}

