package lk.ijse.gdse.common.dto;


import java.util.Date;

public class RecordDTO implements SuperDTO{
    private String recordID;
    private String recordName;
    private String recordCategory;
    private String incidentLocation;
    private Date incidentDate;
    private Date incidentTIme;
    private String victimsName;
    private String recordDec;

    public RecordDTO() {
    }

    public RecordDTO(String recordID, String recordName, String recordCategory, String incidentLocation, Date incidentDate, Date incidentTIme, String victimsName, String recordDec) {
        this.recordID = recordID;
        this.recordName = recordName;
        this.recordCategory = recordCategory;
        this.incidentLocation = incidentLocation;
        this.incidentDate = incidentDate;
        this.incidentTIme = incidentTIme;
        this.victimsName = victimsName;
        this.recordDec = recordDec;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRecordCategory() {
        return recordCategory;
    }

    public void setRecordCategory(String recordCategory) {
        this.recordCategory = recordCategory;
    }

    public String getIncidentLocation() {
        return incidentLocation;
    }

    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public Date getIncidentTIme() {
        return incidentTIme;
    }

    public void setIncidentTIme(Date incidentTIme) {
        this.incidentTIme = incidentTIme;
    }

    public String getVictimsName() {
        return victimsName;
    }

    public void setVictimsName(String victimsName) {
        this.victimsName = victimsName;
    }

    public String getRecordDec() {
        return recordDec;
    }

    public void setRecordDec(String recordDec) {
        this.recordDec = recordDec;
    }

    @Override
    public String toString() {
        return "RecordDTO{" +
                "recordID=" + recordID +
                ", recordName='" + recordName + '\'' +
                ", recordCategory='" + recordCategory + '\'' +
                ", incidentLocation='" + incidentLocation + '\'' +
                ", incidentDate=" + incidentDate +
                ", incidentTIme=" + incidentTIme +
                ", victimsName='" + victimsName + '\'' +
                ", recordDec='" + recordDec + '\'' +
                '}';
    }
}
