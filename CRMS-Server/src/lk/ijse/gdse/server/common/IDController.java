package lk.ijse.gdse.server.common;

import lk.ijse.gdse.server.entity.Criminal;
import lk.ijse.gdse.server.entity.Record;
import lk.ijse.gdse.server.entity.User;
import lk.ijse.gdse.server.resources.HibUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class IDController {

    public static String getLastID(String tableName,String columnName) throws Exception{
        Object table=null;
        String returnId=null;
        SessionFactory sessionFactory = HibUtil.getSessionFactory();
        try(Session session=sessionFactory.openSession()) {
            session.beginTransaction();

            table = session.createQuery("from "+tableName+" ORDER BY "+columnName+" DESC")
                    .setMaxResults(1).uniqueResult();

            session.getTransaction().commit();
        }
        switch (tableName){
            case "Criminal": {
                Criminal criminal = (Criminal) table;
                returnId = criminal.getCriminalId();
            }
            break;
            case "Record": {
                Record record = (Record) table;
                returnId = record.getRecordID();
            }
            break;
            case "User": {
                User user = (User) table;
                returnId = user.getId();
            }
            break;
        }
        return returnId;
    }
}
