/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PermissionDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class PermissionDetailDAO {
    
    public ArrayList<PermissionDetailDTO> getByPermissionId(int id) {
        ArrayList<PermissionDetailDTO> list = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();

            String query = "SELECT * FROM permission_details WHERE permission_id = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int permission_id = rs.getInt("permission_id");
                int function_id = rs.getInt("function_id");
                String action = rs.getString("action");

                PermissionDetailDTO permission_detail = new PermissionDetailDTO(permission_id, function_id, action);

                list.add(permission_detail);
            }

            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public int add(ArrayList<PermissionDetailDTO> list) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();
            
            for (PermissionDetailDTO permissionDetail : list) {

                String query = "INSERT INTO permission_details (permission_id, function_id, action) VALUES (?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(query);

                ps.setInt(1, permissionDetail.getPermission_id());
                ps.setInt(2, permissionDetail.getFunction_id());
                ps.setString(3, permissionDetail.getAction());

                result += ps.executeUpdate();
                
            }
            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
    public int deleteByPermissionId(int permissionId) {
        int result = 0;

        try {
            Connection connection = Database.getConnection();
            
                String query = "DELETE FROM permission_details WHERE permission_id = ?";
                PreparedStatement ps = connection.prepareStatement(query);

                ps.setInt(1, permissionId);

                result += ps.executeUpdate();
                
            Database.closeConnection(connection);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
    public int update(ArrayList<PermissionDetailDTO> pdList, int pId) {
        int result = this.deleteByPermissionId(pId);
        if(result >= 0) result = this.add(pdList);
        return result;
    }
    
}
