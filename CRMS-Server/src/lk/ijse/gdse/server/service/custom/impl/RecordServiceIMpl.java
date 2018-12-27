package lk.ijse.gdse.server.service.custom.impl;

import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.common.observer.Observer;
import lk.ijse.gdse.common.service.custom.RecordService;
import lk.ijse.gdse.server.business.BusinessFactory;
import lk.ijse.gdse.server.business.custom.RecordBusiness;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RecordServiceIMpl extends UnicastRemoteObject implements RecordService {
    private RecordBusiness recordBusiness;

    public RecordServiceIMpl() throws RemoteException {
        recordBusiness = BusinessFactory.getInstance().getBussinessFor(BusinessFactory.BusinessTypes.RECORD);
    }

    @Override
    public boolean addRecord(RecordDTO recordDTO) throws Exception {
        return recordBusiness.addRecord(recordDTO);
    }

    @Override
    public void register(Observer observer) throws Exception {

    }

    @Override
    public void unregister(Observer observer) throws Exception {

    }

    @Override
    public void notifyAllObservers(String message) throws Exception {

    }

    @Override
    public boolean reserved(Object id) throws Exception {
        return false;
    }

    @Override
    public boolean released(Object id) throws Exception {
        return false;
    }
}
