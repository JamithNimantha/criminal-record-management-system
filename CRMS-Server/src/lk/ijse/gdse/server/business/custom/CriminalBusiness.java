package lk.ijse.gdse.server.business.custom;

import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.common.dto.CriminalDetailDTO;
import lk.ijse.gdse.server.business.SuperBusiness;

import java.util.List;

public interface CriminalBusiness extends SuperBusiness {
    public boolean addCriiminal(CriminalDTO criminalDTO, String recordID) throws Exception;
    public boolean updateCriminal(CriminalDTO criminalDTO, String recordID) throws Exception;
    public boolean deleteCriminal(CriminalDTO criminalDTO, String recordID) throws Exception;
    public CriminalDTO searchCriminal(String id) throws Exception;
    public List<CriminalDetailDTO> getAllCriminals() throws Exception;


}
