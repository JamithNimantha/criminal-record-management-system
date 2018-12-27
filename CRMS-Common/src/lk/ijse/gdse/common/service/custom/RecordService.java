package lk.ijse.gdse.common.service.custom;

import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.common.service.SuperService;

import java.util.List;

public interface RecordService extends SuperService {
    public boolean addRecord(RecordDTO recordDTO) throws Exception;
    public boolean updateRecord(RecordDTO recordDTO) throws Exception;
    public boolean deleteRecord(RecordDTO recordDTO) throws Exception;
    public RecordDTO searchRecord(int id) throws Exception;
    public List<RecordDTO> getAllRecords() throws Exception;
}
