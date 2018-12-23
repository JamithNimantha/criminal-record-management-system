package lk.ijse.gdse.server.business;

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
        USER;
    }
    public <T> T getBussinessFor(BusinessTypes types){
        switch (types){
            case USER:
                return (T) new UserBusinessImpl();
                default:
                    return null;
        }
    }
}
