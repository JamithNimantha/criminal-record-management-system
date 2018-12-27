package lk.ijse.gdse.server.service.custom.impl;

import lk.ijse.gdse.common.dto.RecordDTO;
import lk.ijse.gdse.common.observer.Observer;
import lk.ijse.gdse.common.service.custom.RecordService;
import lk.ijse.gdse.server.business.BusinessFactory;
import lk.ijse.gdse.server.business.custom.RecordBusiness;
import lk.ijse.gdse.server.reservation.impl.ReservationsImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RecordServiceIMpl extends UnicastRemoteObject implements RecordService {
    private RecordBusiness recordBusiness;
    private static ArrayList<Observer> observers = new ArrayList<>();
    private static ReservationsImpl<RecordService> recordServiceReservations= new ReservationsImpl<>();

    public RecordServiceIMpl() throws RemoteException {
        recordBusiness = BusinessFactory.getInstance().getBussinessFor(BusinessFactory.BusinessTypes.RECORD);
    }

    @Override
    public boolean addRecord(RecordDTO recordDTO) throws Exception {
        notifyAllObservers(recordDTO.getRecordID()+" is Added...");
        return recordBusiness.addRecord(recordDTO);
    }

    @Override
    public boolean updateRecord(RecordDTO recordDTO) throws Exception {
        if (recordServiceReservations.reserve(recordDTO.getRecordID(),this,true)){
            boolean updateRecord = recordBusiness.updateRecord(recordDTO);
            if (updateRecord){
                if (recordServiceReservations.checkState(recordDTO.getRecordID(),this)){
                    recordServiceReservations.release(recordDTO.getRecordID(),this);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteRecord(RecordDTO recordDTO) throws Exception {
        if (recordServiceReservations.reserve(recordDTO.getRecordID(),this,true)){
            boolean deleteRecord = recordBusiness.deleteRecord(recordDTO);
            if (deleteRecord){
                if (recordServiceReservations.checkState(recordDTO.getRecordID(),this)){
                    recordServiceReservations.release(recordDTO.getRecordID(),this);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public RecordDTO searchRecord(int id) throws Exception {
        return recordBusiness.searchRecord(id);
    }

    @Override
    public List<RecordDTO> getAllRecords() throws Exception {
        return recordBusiness.getAllRecords();
    }

    @Override
    public void register(Observer observer) throws Exception {
        observers.add(observer);

    }

    @Override
    public void unregister(Observer observer) throws Exception {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
        for (Observer observer: observers){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        observer.update(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

    @Override
    public boolean reserved(Object id) throws Exception {
        return recordServiceReservations.reserve(id,this,true);
    }

    @Override
    public boolean released(Object id) throws Exception {
        return recordServiceReservations.release(id,this);
    }
}
