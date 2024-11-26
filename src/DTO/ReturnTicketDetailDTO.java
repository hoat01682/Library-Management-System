package DTO;

public class ReturnTicketDetailDTO {
    
    private int id;
    private int returnTicket_id;
    private int borrow_ticket_id;
    private String isbn;
    private String status;

    public ReturnTicketDetailDTO(int returnTicket_id, int borrow_ticket_id, String isbn, String status) {
        this.returnTicket_id = returnTicket_id;
        this.borrow_ticket_id = borrow_ticket_id;
        this.isbn = isbn;
        this.status = status;
    }

    public ReturnTicketDetailDTO(int id, int returnTicket_id, int borrow_ticket_id, String isbn, String status) {
        this.id = id;
        this.returnTicket_id = returnTicket_id;
        this.borrow_ticket_id = borrow_ticket_id;
        this.isbn = isbn;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReturnTicket_id() {
        return returnTicket_id;
    }

    public void setReturnTicket_id(int returnTicket_id) {
        this.returnTicket_id = returnTicket_id;
    }

    public int getBorrow_ticket_id() {
        return borrow_ticket_id;
    }

    public void setBorrow_ticket_id(int borrow_ticket_id) {
        this.borrow_ticket_id = borrow_ticket_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReturnTicketDetailDTO{" + "id=" + id + ", returnTicket_id=" + returnTicket_id + ", borrow_ticket_id=" + borrow_ticket_id + ", isbn=" + isbn + ", status=" + status + '}';
    }

}
