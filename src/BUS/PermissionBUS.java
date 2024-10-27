/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PermissionDAO;
import DTO.PermissionDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class PermissionBUS {
    
    private final PermissionDAO permissionDAO = new PermissionDAO();
    
    public ArrayList<PermissionDTO> getAll() {
        return permissionDAO.getAll();
    }
    
    public PermissionDTO getById(int id) {
        return permissionDAO.getById(id);
    }
    
}
