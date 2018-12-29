package lk.ijse.gdse.server.business.custom.impl;

import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.server.business.custom.RecordBusiness;
import lk.ijse.gdse.server.common.IDGenerator;
import lk.ijse.gdse.server.entity.Record;
import lk.ijse.gdse.server.repository.RepoFactory;
import lk.ijse.gdse.server.repository.custom.RecordRepo;
import lk.ijse.gdse.server.resources.HibUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class RecordBusinessImpl implements RecordBusiness {
    private RecordRepo recordRepo=RepoFactory.getInstance().RepoFactoryFor(RepoFactory.RepoTypes.RECORD);

    @Override
    public boolean addRecord(RecordDTO dto) throws Exception {
        boolean result;
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            recordRepo.setSession(session);
            session.beginTransaction();
            result = recordRepo.add(
                    new Record(
                            dto.getRecordID(),
                            dto.getRecordName(),
                            dto.getRecordCategory(),
                            dto.getIncidentLocation(),
                            dto.getIncidentDate(),
                            dto.getIncidentTIme(),
                            dto.getVictimsName(),
                            dto.getRecordDec()
                    ));
            session.getTransaction().commit();
        }
        return result;

    }

    @Override
    public boolean updateRecord(RecordDTO dto) throws Exception {
        boolean result;
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            recordRepo.setSession(session);
            session.beginTransaction();
            result = recordRepo.update(
                    new Record(
                            dto.getRecordID(),
                            dto.getRecordName(),
                            dto.getRecordCategory(),
                            dto.getIncidentLocation(),
                            dto.getIncidentDate(),
                            dto.getIncidentTIme(),
                            dto.getVictimsName(),
                            dto.getRecordDec()
                    ));
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public boolean deleteRecord(RecordDTO dto) throws Exception {
        boolean result;
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            recordRepo.setSession(session);
            session.beginTransaction();
            result = recordRepo.delete(
                    new Record(
                            dto.getRecordID(),
                            dto.getRecordName(),
                            dto.getRecordCategory(),
                            dto.getIncidentLocation(),
                            dto.getIncidentDate(),
                            dto.getIncidentTIme(),
                            dto.getVictimsName(),
                            dto.getRecordDec()
                    ));
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public RecordDTO searchRecord(String id) throws Exception {
        Record record;
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            recordRepo.setSession(session);
            session.getTransaction().begin();
            record= recordRepo.search(id);
        }
        return new RecordDTO(
                record.getRecordID(),
                record.getRecordName(),
                record.getRecordCategory(),
                record.getIncidentLocation(),
                record.getIncidentDate(),
                record.getIncidentTIme(),
                record.getVictimsName(),
                record.getRecordDec()
        );

    }

    @Override
    public List<RecordDTO> getAllRecords() throws Exception {
        List<RecordDTO> recordDTOS;
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            recordRepo.setSession(session);
            session.getTransaction().begin();
            recordDTOS=new ArrayList<>();
            List<Record> all = recordRepo.getAll();
            for (Record record:all){
                recordDTOS.add(
                        new RecordDTO(
                                record.getRecordID(),
                                record.getRecordName(),
                                record.getRecordCategory(),
                                record.getIncidentLocation(),
                                record.getIncidentDate(),
                                record.getIncidentTIme(),
                                record.getVictimsName(),
                                record.getRecordDec()
                        ));
            }
        }
        return recordDTOS;
    }
}
