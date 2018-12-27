package lk.ijse.gdse.server.business.custom;

import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.server.business.SuperBusiness;

import java.util.List;

public interface CriminalBusiness extends SuperBusiness {
    public boolean addCriiminal(CriminalDTO criminalDTO, int recordID) throws Exception;
    public boolean updateCriminal(CriminalDTO criminalDTO,int recordID) throws Exception;
    public boolean deleteCriminal(CriminalDTO criminalDTO,int recordID) throws Exception;
    public CriminalDTO searchCriminal(int id) throws Exception;
    public List<CriminalDTO> getAllCriminals() throws Exception;


}
