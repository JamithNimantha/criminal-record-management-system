package lk.ijse.gdse.common.service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote {
    public enum ServiceTypes{
        USER,RECORD,CRIMINAL,CRIMINALRECORDDETAIL;
    }

    public <T> T getSuperService(ServiceTypes serviceTypes) throws Exception;
}
