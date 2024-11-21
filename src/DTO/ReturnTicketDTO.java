package DTO;

public class ReturnTicketDTO {
    private String returnTicketId;//mã phiếu trả
    private String borrowTicketId;//mã phiếu mượn
    private int staffId;//mã nhân viên
    private String returnDate;//ngày trả
    private String status;//trạng thái
    
    // Getters and setters
    public String getReturnTicketId() {
        return returnTicketId;
    }

    public void setReturnTicketId(String returnTicketId) {
        this.returnTicketId = returnTicketId;
    }

    public String getBorrowTicketId() {
        return borrowTicketId;
    }

    public void setBorrowTicketId(String borrowTicketId) {
        this.borrowTicketId = borrowTicketId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}