package lk.ijse.gdse.common.service.custom;

import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.common.dto.CriminalDetailDTO;
import lk.ijse.gdse.common.service.SuperService;

import java.util.List;

public interface CriminalService extends SuperService {
    public boolean addCriminal(CriminalDTO criminalDTO, String recordID) throws Exception;
    public boolean updateCriminal(CriminalDTO criminalDTO, String recordID) throws Exception;
    public boolean deleteCriminal(CriminalDTO criminalDTO, String recordID) throws Exception;
    public CriminalDTO searchCriminal(String id)throws Exception;
    public List<CriminalDetailDTO> getAllCriminals() throws Exception;

}
