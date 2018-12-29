package lk.ijse.gdse.server.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CriminalRecordDetails implements Serializable {

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Criminal criminal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Record record;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int incriment;

    public CriminalRecordDetails(Criminal criminal, Record record) {
        this.criminal = criminal;
        this.record = record;
    }

    public CriminalRecordDetails(Criminal criminal, Record record,int incriment ) {
        this.criminal = criminal;
        this.record = record;
        this.incriment=incriment;
    }

    public int getIncriment() {
        return incriment;
    }

    public void setIncriment(int incriment) {
        this.incriment = incriment;
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
