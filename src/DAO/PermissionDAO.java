/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PermissionDTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Duc3m
 */
public class PermissionDAO {
    
    public ArrayList<PermissionDTO> getAll() {
        ArrayList<PermissionDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM `permission`";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("permission_id");
                String name = rs.getString("permission_name");

                PermissionDTO permission = new PermissionDTO(id, name);

                list.add(permission);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public PermissionDTO getById(int id) {
        PermissionDTO permission = null;
        
        try {
            Connection connection = Database.getConnection();
            
            String query = "SELECT * FROM `permission` WHERE permission_id = ?";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id); 
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int permission_id = rs.getInt("permission_id");
                String permission_name = rs.getString("permission_name");

                permission = new PermissionDTO(permission_id, permission_name);
            }
            
            Database.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return permission;
    }
    
}
