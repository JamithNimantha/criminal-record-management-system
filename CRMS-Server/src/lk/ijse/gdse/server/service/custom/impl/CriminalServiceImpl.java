package lk.ijse.gdse.server.service.custom.impl;

import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.common.observer.Observer;
import lk.ijse.gdse.common.service.custom.CriminalService;
import lk.ijse.gdse.server.business.BusinessFactory;
import lk.ijse.gdse.server.business.custom.CriminalBusiness;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CriminalServiceImpl extends UnicastRemoteObject implements CriminalService {
    private CriminalBusiness criminalBusiness;
    public CriminalServiceImpl() throws RemoteException {
        criminalBusiness = BusinessFactory.getInstance().getBussinessFor(BusinessFactory.BusinessTypes.CRIMINAL);
    }

    @Override
    public boolean addCriiminalCase(CriminalDTO criminalDTO, int recordID) throws Exception {
        return criminalBusiness.addCriiminal(criminalDTO,recordID);
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
