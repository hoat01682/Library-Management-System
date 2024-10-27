/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Dương
 */
public class MemberDTO {
    private int member_id;
    private String full_name;
    private String phone;
    private String address; 
    private String membership_date;  
    private String status;
    private int violationCount;

    public MemberDTO() {
        this.violationCount=0;
    }

    public MemberDTO(String full_name, String phone, String address) {
        this.full_name = full_name;
        this.phone = phone;
        this.address = address;
    }

    public MemberDTO(int member_id, String full_name, String phone, String address, String membership_date, String status, int violationCount) {
        this.member_id = member_id;
        this.full_name = full_name;
        this.phone = phone;
        this.address = address;
        this.membership_date = membership_date;
        this.status = status;
        this.violationCount = violationCount;
    }
    



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMembership_date() {
        return membership_date;
    }

    public void setMembership_date(String membership_date) {
        this.membership_date = membership_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  public int getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(int violationCount) {
        this.violationCount = violationCount;
    }

    
    
    
    


    
    
            
    
}
