package lk.ijse.gdse.common.service.custom;

import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.common.service.SuperService;

public interface RecordService extends SuperService {
    public boolean addRecord(RecordDTO recordDTO) throws Exception;
}
