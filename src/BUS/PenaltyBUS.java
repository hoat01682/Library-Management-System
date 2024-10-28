package BUS;

import DAO.PenaltyDAO;
import DTO.PenaltyDTO;
import java.util.ArrayList;

public class PenaltyBUS {
    private final PenaltyDAO penaltyDAO = new PenaltyDAO();

    public boolean createPenalty(PenaltyDTO penalty) {
        return penaltyDAO.add(penalty) > 0;
    }

    public boolean removePenalty(PenaltyDTO penalty) {
        return penaltyDAO.remove(penalty) > 0;
    }

    public boolean updatePenalty(PenaltyDTO penalty) {
        return penaltyDAO.update(penalty) > 0;
    }

    public ArrayList<PenaltyDTO> sortPenaltyOrderByInc() {
        return penaltyDAO.sortIncrease();
    }

    public ArrayList<PenaltyDTO> sortPenaltyOrderByDesc() {
        return penaltyDAO.sortDecrease();
    }

    public ArrayList<PenaltyDTO> getAll() {
        return penaltyDAO.getAll();
    }

    public ArrayList<PenaltyDTO> getById(int id) {
        return penaltyDAO.getById(id);
    }
}