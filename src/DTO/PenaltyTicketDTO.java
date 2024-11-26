package DTO;

import java.sql.Timestamp;

public class PenaltyTicketDTO {
    private int id;
    private int member_id;
    private int staff_id;
    private int penalty_id;
    private Timestamp penalty_date;
    private String note;
    private int returnTicket_id;
    private int fine;

    public PenaltyTicketDTO(int member_id, int staff_id, int penalty_id, Timestamp penalty_date, String note, int returnTicket_id, int fine) {
        this.member_id = member_id;
        this.staff_id = staff_id;
        this.penalty_id = penalty_id;
        this.penalty_date = penalty_date;
        this.note = note;
        this.returnTicket_id = returnTicket_id;
        this.fine = fine;
    }

    public PenaltyTicketDTO(int id, int member_id, int staff_id, int penalty_id, Timestamp penalty_date, String note, int returnTicket_id, int fine) {
        this.id = id;
        this.member_id = member_id;
        this.staff_id = staff_id;
        this.penalty_id = penalty_id;
        this.penalty_date = penalty_date;
        this.note = note;
        this.returnTicket_id = returnTicket_id;
        this.fine = fine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getPenalty_id() {
        return penalty_id;
    }

    public void setPenalty_id(int penalty_id) {
        this.penalty_id = penalty_id;
    }

    public Timestamp getPenalty_date() {
        return penalty_date;
    }

    public void setPenalty_date(Timestamp penalty_date) {
        this.penalty_date = penalty_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getReturnTicket_id() {
        return returnTicket_id;
    }

    public void setReturnTicket_id(int returnTicket_id) {
        this.returnTicket_id = returnTicket_id;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

}