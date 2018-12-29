package lk.ijse.gdse.server.business.custom;

import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.server.business.SuperBusiness;

import java.util.List;

public interface RecordBusiness extends SuperBusiness {
    public boolean addRecord(RecordDTO recordDTO) throws Exception;
    public boolean updateRecord(RecordDTO recordDTO) throws  Exception;
    public boolean deleteRecord(RecordDTO recordDTO) throws Exception;
    public RecordDTO searchRecord(String id) throws  Exception;
    public List<RecordDTO> getAllRecords() throws Exception;
}
