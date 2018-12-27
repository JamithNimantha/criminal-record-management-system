package lk.ijse.gdse.server.business;

import lk.ijse.gdse.server.business.custom.impl.CriminalBusinessImpl;
import lk.ijse.gdse.server.business.custom.impl.RecordBusinessImpl;
import lk.ijse.gdse.server.business.custom.impl.UserBusinessImpl;

public class BusinessFactory {
    private  static BusinessFactory businessFactory;

    public static BusinessFactory getInstance(){
        if (businessFactory==null){
            businessFactory=new BusinessFactory();
        }
        return  businessFactory;
    }

    public enum BusinessTypes{
        USER,RECORD,CRIMINAL,CRIMINALRECORDDETAIL;
    }
    public <T> T getBussinessFor(BusinessTypes types){
        switch (types){
            case USER:
                return (T) new UserBusinessImpl();
            case RECORD:
                return (T) new RecordBusinessImpl();
            case CRIMINAL:
                return (T) new CriminalBusinessImpl();
                default:
                    return null;
        }
    }
}
