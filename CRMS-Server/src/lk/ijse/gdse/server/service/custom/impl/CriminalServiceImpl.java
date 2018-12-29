package lk.ijse.gdse.server.service.custom.impl;

import lk.ijse.gdse.common.dto.CriminalDTO;
import lk.ijse.gdse.common.dto.CriminalDetailDTO;
import lk.ijse.gdse.common.observer.Observer;
import lk.ijse.gdse.common.service.custom.CriminalService;
import lk.ijse.gdse.server.business.BusinessFactory;
import lk.ijse.gdse.server.business.custom.CriminalBusiness;
import lk.ijse.gdse.server.reservation.impl.ReservationsImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CriminalServiceImpl extends UnicastRemoteObject implements CriminalService {
    private CriminalBusiness criminalBusiness =BusinessFactory.getInstance().getBussinessFor(BusinessFactory.BusinessTypes.CRIMINAL);;
    private static ArrayList<Observer> allCriminalObservers = new ArrayList<>();
    private static ReservationsImpl<CriminalService> reservations = new ReservationsImpl<>();
    public CriminalServiceImpl() throws RemoteException {
    }

    @Override
    public boolean addCriminal(CriminalDTO criminalDTO, String recordID) throws Exception {
        notifyAllObservers(criminalDTO.getCriminalId()+" is Added !!");
        return criminalBusiness.addCriiminal(criminalDTO,recordID);
    }

    @Override
    public boolean updateCriminal(CriminalDTO criminalDTO, String recordID) throws Exception {
        if (reservations.reserve(criminalDTO.getCriminalId(),this,true)){
            boolean updateCriminal=criminalBusiness.updateCriminal(criminalDTO,recordID);
            if (updateCriminal){
                if (reservations.checkState(criminalDTO.getCriminalId(),this)){
                    reservations.release(criminalDTO.getCriminalId(),this);
                    return  true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteCriminal(CriminalDTO criminalDTO, String recordID) throws Exception {
        if (reservations.reserve(criminalDTO.getCriminalId(),this,true)){
            boolean updateCriminal=criminalBusiness.deleteCriminal(criminalDTO,recordID);
            if (updateCriminal){
                if (reservations.checkState(criminalDTO.getCriminalId(),this)){
                    reservations.release(criminalDTO.getCriminalId(),this);
                    return  true;
                }
            }
        }
        return false;
    }

    @Override
    public CriminalDTO searchCriminal(String id) throws Exception {
        return null;

    }

    @Override
    public List<CriminalDetailDTO> getAllCriminals() throws Exception {
        return criminalBusiness.getAllCriminals();
    }

    @Override
    public void register(Observer observer) throws Exception {
        allCriminalObservers.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
        allCriminalObservers.remove(observer);
    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
        for (Observer allObserver : allCriminalObservers){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        allObserver.update(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Override
    public boolean reserved(Object id) throws Exception {
        return reservations.reserve(id,this,true);
    }

    @Override
    public boolean released(Object id) throws Exception {
        return reservations.release(id,this);
    }
}
