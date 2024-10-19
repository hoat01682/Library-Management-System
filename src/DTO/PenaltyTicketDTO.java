package DTO;

public class PenaltyTicketDTO {
    private int id;
    private int member_id;
    private int staff_id;
    private int penalty_id;
    private String penalty_date;
    private String note;

    public PenaltyTicketDTO(int id, int member_id, int staff_id, int penalty_id, String penalty_date, String note) {
        this.id = id;
        this.member_id = member_id;
        this.staff_id = staff_id;
        this.penalty_id = penalty_id;
        this.penalty_date = penalty_date;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return member_id;
    }

    public void setMemberId(int member_id) {
        this.member_id = member_id;
    }

    public int getStaffId() {
        return staff_id;
    }
    
    public void setStaffId(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getPenaltyId() {
        return penalty_id;
    }

    public void setPenaltyId(int penalty_id) {
        this.penalty_id = penalty_id;
    }

    public String getPenaltyDate() {
        return penalty_date;
    }

    public void setPenaltyDate(String penalty_date) {
        this.penalty_date = penalty_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}