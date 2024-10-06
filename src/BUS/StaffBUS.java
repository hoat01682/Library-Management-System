/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.StaffDAO;
import DTO.StaffDTO;
import java.util.ArrayList;

/**
 *
 * @author hieun
 */
public class StaffBUS {
    
    private final StaffDAO staffDAO = new StaffDAO();

    public boolean createStaff(StaffDTO staff) {
        return staffDAO.add(staff) > 0;
    }

    public boolean updateStaff(StaffDTO staff) {
        return staffDAO.update(staff) > 0;
    }

    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public StaffDTO getById(int id) {
        return staffDAO.getById(id);
    }
    
    public ArrayList<StaffDTO> getByStatus(int status) {
        return staffDAO.getByStatus(status);
    }

    public ArrayList<StaffDTO> getAllStaff() {
        return staffDAO.getAll();
    }
}
