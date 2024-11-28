/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PublisherDAO;
import DTO.PublisherDTO;
import java.util.ArrayList;

/**
 *
 * @author Duc3m
 */
public class PublisherBUS {
    
    PublisherDAO publisherDAO = new PublisherDAO();
    
    public static PublisherBUS getInstance() {
        return new PublisherBUS();
    }
    
    public ArrayList<PublisherDTO> getAll() {
        return publisherDAO.getAll();
    }
    
    public PublisherDTO getById(int id) {
        return publisherDAO.getById(id);
    }
    
    public boolean add(PublisherDTO publisher) {
        return publisherDAO.add(publisher) > 0;
    }
    
    public boolean update(PublisherDTO publisher) {
        return publisherDAO.update(publisher) > 0;
    }
    
}
