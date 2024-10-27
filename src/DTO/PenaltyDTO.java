package DTO;

public class PenaltyDTO {
    private int id;
    private String penalty_name;
    private Double amount;

    public PenaltyDTO(int id, String penalty_name, Double amount) {
        this.id = id;
        this.penalty_name = penalty_name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPenaltyName() {
        return penalty_name;
    }

    public void setPenaltyName(String penalty_name) {
        this.penalty_name =  penalty_name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}