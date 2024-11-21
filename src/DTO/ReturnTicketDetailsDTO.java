package DTO;


public class ReturnTicketDetailsDTO {
    //Thuộc tính bảng
    private int returnTicketdetailsId;//mã chi tiết phiếu trả
    private String returnTicketId;//mã phiếu trả
    private String isbn;//mã bản sách


    // Getters and setters
    public int getreturnTicketdetailsId() {
        return returnTicketdetailsId;
    }

    public void setreturnTicketdetailsId(int returnTicketdetailsId) {
        this.returnTicketdetailsId = returnTicketdetailsId;
    }

    public String getreturnTicketId() {
        return returnTicketId;
    }

    public void setreturnTicketId(String returnTicketId) {
        this.returnTicketId = returnTicketId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
