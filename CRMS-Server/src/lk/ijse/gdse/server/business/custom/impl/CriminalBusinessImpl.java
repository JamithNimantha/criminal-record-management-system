package lk.ijse.gdse.server.business.custom.impl;

import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.common.dto.CriminalDetailDTO;
import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.server.business.custom.CriminalBusiness;
import lk.ijse.gdse.server.common.IDGenerator;
import lk.ijse.gdse.server.entity.Criminal;
import lk.ijse.gdse.server.entity.CriminalRecordDetails;
import lk.ijse.gdse.server.entity.Record;
import lk.ijse.gdse.server.repository.RepoFactory;
import lk.ijse.gdse.server.repository.custom.CriminalRepo;
import lk.ijse.gdse.server.resources.HibUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.BlobProxy;

import java.util.ArrayList;
import java.util.List;

public class CriminalBusinessImpl implements CriminalBusiness {
    private CriminalRepo criminalRepo;

    public CriminalBusinessImpl() {
        criminalRepo = RepoFactory.getInstance().RepoFactoryFor(RepoFactory.RepoTypes.CRIMINAL);
    }

    @Override
    public boolean addCriiminal(CriminalDTO dto, String recordID) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            criminalRepo.setSession(session);
            Record record = session.get(Record.class, recordID);
            Criminal criminal = new Criminal(
                    IDGenerator.getNewID("Criminal","criminalId","IRC"),
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
                    dto.getPoliticalView(),
                    dto.getReligion(),
                    dto.getHeight(),
                    dto.getComplexion(),
                    dto.getHair(),
                    dto.getEyes(),
                    BlobProxy.generateProxy(dto.getPhoto())

            );
            criminalRepo.add(criminal);
            CriminalRecordDetails criminalRecordDetails = new CriminalRecordDetails(criminal, record);
            session.save(criminalRecordDetails);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCriminal(CriminalDTO dto, String recordID) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            criminalRepo.setSession(session);
            Record record = session.get(Record.class, recordID);
            Criminal criminal = new Criminal(
                    dto.getCriminalId(),
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
                    dto.getPoliticalView(),
                    dto.getReligion(),
                    dto.getHeight(),
                    dto.getComplexion(),
                    dto.getHair(),
                    dto.getEyes(),
                    BlobProxy.generateProxy(dto.getPhoto())

            );
            criminalRepo.update(criminal);
            CriminalRecordDetails criminalRecordDetails = new CriminalRecordDetails(criminal, record);
            session.save(criminalRecordDetails);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCriminal(CriminalDTO dto, String recordID) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            criminalRepo.setSession(session);
            Record record = session.get(Record.class, recordID);
            Criminal criminal = new Criminal(
                    dto.getCriminalId(),
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
                    dto.getPoliticalView(),
                    dto.getReligion(),
                    dto.getHeight(),
                    dto.getComplexion(),
                    dto.getHair(),
                    dto.getEyes(),
                    BlobProxy.generateProxy(dto.getPhoto())

            );
            criminalRepo.delete(criminal);
            CriminalRecordDetails criminalRecordDetails = new CriminalRecordDetails(criminal, record);
            session.save(criminalRecordDetails);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CriminalDTO searchCriminal(String id) throws Exception {
        return null;
    }

    @Override
    public List<CriminalDetailDTO> getAllCriminals() throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {

            List<CriminalDetailDTO> criminalDetailDTOS = new ArrayList<>();

            criminalRepo.setSession(session);
            session.beginTransaction();
            List list = session.createSQLQuery("SELECT COUNT(record_recordID) FROM CriminalRecordDetails").list();
            int count = Integer.parseInt(list.get(0).toString());
//            int count = (int) list.get(0);
            for (; count > 0; count--) {

                List from = session.createSQLQuery("SELECT  criminal_criminalId FROM  CriminalRecordDetails where incriment='"+ count+"'").list();
                List from1 = session.createSQLQuery("SELECT  record_recordID FROM  CriminalRecordDetails where incriment='"+ count+"' ").list();
//                session.createSQLQuery("SELECT incriment FROM CriminalRecordDetails");

                String crimalID = from.get(0).toString();
                Criminal criminal = session.get(Criminal.class, crimalID);
                String recordId = from1.get(0).toString();
                Record record = session.get(Record.class, recordId);

//                BufferedImage bufferedImage = SwingFXUtils.fromFXImage((Image) criminal.getPhoto(), null);
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
//                byte[] bytes = byteArrayOutputStream.toByteArray();
//                byteArrayOutputStream.close();


                CriminalDTO criminalDTO = new CriminalDTO(
                        criminal.getCriminalId(),
                        criminal.getCriminalName(),
                        criminal.getCriminalNickName(),
                        criminal.getCriminalNIC(),
                        criminal.getCriminalDOB(),
                        criminal.getAge(),
                        criminal.getGender(),
                        criminal.getBirthRegID(),
                        criminal.getBirthPlace(),
                        criminal.getCivilStatus(),
                        criminal.getOccupation(),
                        criminal.getAddress(),
                        criminal.getEthnicity(),
                        criminal.getPoliticalView(),
                        criminal.getReligion(),
                        criminal.getHeight(),
                        criminal.getComplexion(),
                        criminal.getHair(),
                        criminal.getEyes(),
                        //null
                        criminal.getPhoto().getBytes(1, (int) criminal.getPhoto().length())
//
                );

                RecordDTO recordDTO = new RecordDTO(
                        record.getRecordID(),
                        record.getRecordName(),
                        record.getRecordCategory(),
                        record.getIncidentLocation(),
                        record.getIncidentDate(),
                        record.getIncidentTIme(),
                        record.getVictimsName(),
                        record.getRecordDec()
                );

                CriminalDetailDTO criminalDetailDTO = new CriminalDetailDTO(criminalDTO, recordDTO);
                criminalDetailDTOS.add(criminalDetailDTO);

            }


            session.getTransaction().commit();
            return criminalDetailDTOS;
//            return null;
        }
    }
}
