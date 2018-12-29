package lk.ijse.gdse.common.dto;

public class CriminalDetailDTO implements SuperDTO{
    private CriminalDTO criminal;
    private RecordDTO record;

    public CriminalDetailDTO(CriminalDTO criminal, RecordDTO record) {
        this.criminal = criminal;
        this.record = record;
    }

    public CriminalDetailDTO() {
    }

    public CriminalDTO getCriminal() {
        return criminal;
    }

    public void setCriminal(CriminalDTO criminal) {
        this.criminal = criminal;
    }

    public RecordDTO getRecord() {
        return record;
    }

    public void setRecord(RecordDTO record) {
        this.record = record;
    }
}
