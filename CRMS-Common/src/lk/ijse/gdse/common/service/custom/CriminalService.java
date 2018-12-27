package lk.ijse.gdse.common.service.custom;

import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.common.service.SuperService;

public interface CriminalService extends SuperService {
    public boolean addCriiminalCase(CriminalDTO criminalDTO, int recordID) throws Exception;

}
