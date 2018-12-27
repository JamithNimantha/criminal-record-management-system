package lk.ijse.gdse.server.service.impl;

import lk.ijse.gdse.common.service.ServiceFactory;
import lk.ijse.gdse.server.service.custom.impl.CriminalServiceImpl;
import lk.ijse.gdse.server.service.custom.impl.RecordServiceIMpl;
import lk.ijse.gdse.server.service.custom.impl.UserServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    private static ServiceFactoryImpl serviceFactory;

    public ServiceFactoryImpl() throws RemoteException {
    }


    public static ServiceFactoryImpl getInstance() throws Exception{
        if (serviceFactory==null){
            serviceFactory=new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public <T> T getSuperService(ServiceTypes serviceTypes) throws Exception {
        switch (serviceTypes){
            case USER:
                return (T) new UserServiceImpl();
            case RECORD:
                return (T) new RecordServiceIMpl();
            case CRIMINAL:
                return (T) new CriminalServiceImpl();
                default:
                    return null;
        }
    }
}
