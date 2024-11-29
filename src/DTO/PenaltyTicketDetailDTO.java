/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duc3m
 */
public class PenaltyTicketDetailDTO {
    private int id;
    private int penaltyticket_id;
    private int penalty_id;
    private String isbn;
    private int fine;

    public PenaltyTicketDetailDTO(int penaltyticket_id, int penalty_id, String isbn, int fine) {
        this.penaltyticket_id = penaltyticket_id;
        this.penalty_id = penalty_id;
        this.isbn = isbn;
        this.fine = fine;
    }

    public PenaltyTicketDetailDTO(int id, int penaltyticket_id, int penalty_id, String isbn, int fine) {
        this.id = id;
        this.penaltyticket_id = penaltyticket_id;
        this.penalty_id = penalty_id;
        this.isbn = isbn;
        this.fine = fine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPenaltyticket_id() {
        return penaltyticket_id;
    }

    public void setPenaltyticket_id(int penaltyticket_id) {
        this.penaltyticket_id = penaltyticket_id;
    }

    public int getPenalty_id() {
        return penalty_id;
    }

    public void setPenalty_id(int penalty_id) {
        this.penalty_id = penalty_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
    
}
