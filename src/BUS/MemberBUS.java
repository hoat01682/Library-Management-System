/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MemberDAO;
import DTO.MemberDTO;
import java.util.ArrayList;

/**
 *
 * @author Dương
 */
public class MemberBUS {
    private final MemberDAO memberDAO = new MemberDAO();
      
    public static MemberBUS getInstance() {
        return new MemberBUS();
    }

    public boolean createMember(MemberDTO member) {
        return memberDAO.add(member) > 0;
    }

    public boolean updateMember(MemberDTO member) {
        return memberDAO.update(member) > 0;
    }

    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public MemberDTO getById(int id) {
        return memberDAO.getMemberById(id);
    }
    
    public ArrayList<MemberDTO> getByStatus(int status) {
        return memberDAO.getMemberByStatus(status);
    }

    public ArrayList<MemberDTO> getAllMember() {

        return memberDAO.getAllMember();
    }
    public ArrayList<MemberDTO> searchMember(String text){
        return memberDAO.searchMembers(text);
    }
    
    
}
