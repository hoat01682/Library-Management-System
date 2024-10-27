/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PermissionDetailDAO;
import DTO.PermissionDetailDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class PermissionDetailBUS {
    
    private final PermissionDetailDAO permissionDetailDAO = new PermissionDetailDAO();
    
    public ArrayList<PermissionDetailDTO> getByPermissionId(int permission_id) {
        return permissionDetailDAO.getByPermissionId(permission_id);
    }
    
    public boolean add(ArrayList<PermissionDetailDTO> list) {
        return permissionDetailDAO.add(list) > 0;
    }
    
    public boolean deleteByPermissionId(int permissionId) {
        return permissionDetailDAO.deleteByPermissionId(permissionId) > 0;
    }
    
}
