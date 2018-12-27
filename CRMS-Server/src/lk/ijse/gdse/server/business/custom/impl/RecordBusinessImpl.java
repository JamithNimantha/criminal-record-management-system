package lk.ijse.gdse.server.business.custom.impl;

import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.server.business.custom.RecordBusiness;
import lk.ijse.gdse.server.entity.Record;
import lk.ijse.gdse.server.repository.RepoFactory;
import lk.ijse.gdse.server.repository.custom.RecordRepo;
import lk.ijse.gdse.server.resources.HibUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class RecordBusinessImpl implements RecordBusiness {
    private RecordRepo recordRepo;
    public RecordBusinessImpl() {
        recordRepo= RepoFactory.getInstance().RepoFactoryFor(RepoFactory.RepoTypes.RECORD);
    }

    @Override
    public boolean addRecord(RecordDTO dto) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            recordRepo.setSession(session);
            session.beginTransaction();
            Record record=new Record(dto.getRecordName(),dto.getRecordCategory(),dto.getIncidentLocation(),dto.getIncidentDate(),dto.getIncidentTIme(),dto.getVictimsName(),dto.getRecordDec());
            recordRepo.add(record);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateRecord(RecordDTO recordDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRecord(RecordDTO recordDTO) throws Exception {
        return false;
    }

    @Override
    public RecordDTO searchRecord(String id) throws Exception {
        return null;
    }

    @Override
    public List<RecordDTO> getAllRecords() throws Exception {
        return null;
    }
}
