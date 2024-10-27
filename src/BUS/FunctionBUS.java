/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.FunctionDAO;
import DTO.FunctionDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class FunctionBUS {
    
    private final FunctionDAO functionDAO = new FunctionDAO();
    
    public ArrayList<FunctionDTO> getAll() {
        return functionDAO.getAll();
    }
    
}
