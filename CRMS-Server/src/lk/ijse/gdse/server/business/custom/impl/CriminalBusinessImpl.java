package lk.ijse.gdse.server.business.custom.impl;

import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.server.business.custom.CriminalBusiness;
import lk.ijse.gdse.server.entity.Criminal;
import lk.ijse.gdse.server.entity.CriminalRecordDetails;
import lk.ijse.gdse.server.entity.Record;
import lk.ijse.gdse.server.repository.RepoFactory;
import lk.ijse.gdse.server.repository.custom.CriminalRepo;
import lk.ijse.gdse.server.resources.HibUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class CriminalBusinessImpl implements CriminalBusiness {
    private CriminalRepo criminalRepo;
    public CriminalBusinessImpl() {
        criminalRepo= RepoFactory.getInstance().RepoFactoryFor(RepoFactory.RepoTypes.CRIMINAL);
    }

    @Override
    public boolean addCriiminal(CriminalDTO dto, int recordID) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            criminalRepo.setSession(session);
            Record record = session.get(Record.class,1);
            Criminal criminal=new Criminal(
                    dto.getCriminalName(),
                    dto.getCriminalNickName(),
                    dto.getCriminalNIC(),
                    dto.getCriminalDOB(),
                    dto.getAge(),
                    dto.getGender(),
                    dto.getBirthRegID(),
                    dto.getBirthPlace(),
                    dto.getCivilStatus(),
                    dto.getOccupation(),
                    dto.getAddress(),
                    dto.getEthnicity(),
                    dto.getPoloticalView(),
                    dto.getReligion(),
                    dto.getHeight(),
                    dto.getComplexion(),
                    dto.getHair(),
                    dto.getEyes()
            );
            criminalRepo.add(criminal);
            CriminalRecordDetails criminalRecordDetails=new CriminalRecordDetails(criminal,record);
            session.save(criminalRecordDetails);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public boolean updateCriminal(CriminalDTO criminalDTO, int recordID) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCriminal(CriminalDTO criminalDTO, int recordID) throws Exception {
        return false;
    }

    @Override
    public CriminalDTO searchCriminal(int id) throws Exception {
        return null;
    }

    @Override
    public List<CriminalDTO> getAllCriminals() throws Exception {
        return null;
    }
}
