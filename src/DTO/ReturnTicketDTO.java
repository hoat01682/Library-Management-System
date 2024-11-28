package DTO;

import java.sql.Timestamp;

public class ReturnTicketDTO {
    
    private int id;
    private int staff_id;
    private int member_id;
    private Timestamp return_date;
    private String status;

    public ReturnTicketDTO(int staff_id, int member_id, Timestamp return_date, String status) {
        this.staff_id = staff_id;
        this.member_id = member_id;
        this.return_date = return_date;
        this.status = status;
    }
    
    public ReturnTicketDTO(int id, int staff_id, int member_id, Timestamp return_date, String status) {
        this.id = id;
        this.staff_id = staff_id;
        this.member_id = member_id;
        this.return_date = return_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public Timestamp getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Timestamp return_date) {
        this.return_date = return_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReturnTicketDTO{" + "id=" + id  + ", staff_id=" + staff_id + ", member_id=" + member_id + ", return_date=" + return_date + ", status=" + status + '}';
    }
     
}