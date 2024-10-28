package BUS;

import DAO.PenaltyTicketDAO;
import DTO.PenaltyTicketDTO;
import java.util.ArrayList;

public class PenaltyTicketBUS {
    private final PenaltyTicketDAO penaltyTicketDAO = new PenaltyTicketDAO();

    public boolean createPenaltyTicket(PenaltyTicketDTO penaltyTicket) {
        return penaltyTicketDAO.add(penaltyTicket) > 0;
    }

    public boolean removePenaltyTicket(PenaltyTicketDTO penaltyTicket) {
        return penaltyTicketDAO.remove(penaltyTicket) > 0;
    }

    public boolean updatePenaltyTicket(PenaltyTicketDTO penaltyTicket) {
        return penaltyTicketDAO.update(penaltyTicket) > 0;
    }

    public ArrayList<PenaltyTicketDTO> resetPenaltyTicket() {
        return penaltyTicketDAO.reset();
    }

    public ArrayList<PenaltyTicketDTO> filterPenaltyTicketByDate(String startDate, String endDate) {
        return penaltyTicketDAO.filterDate(startDate, endDate);
    }

    public ArrayList<PenaltyTicketDTO> filterPenaltyTicketDynamicType(int type, int id) {
        return penaltyTicketDAO.filterDynamic(type, id);
    }
}