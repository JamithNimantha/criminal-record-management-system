package lk.ijse.gdse.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class CriminalRecordDetails implements Serializable {
    @Id
    @ManyToOne
    private Criminal criminal;
    @Id
    @ManyToOne
    private Record record;

    public CriminalRecordDetails(Criminal criminal, Record record) {
        this.criminal = criminal;
        this.record = record;
    }

    public Criminal getCriminal() {
        return criminal;
    }

    public void setCriminal(Criminal criminal) {
        this.criminal = criminal;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
