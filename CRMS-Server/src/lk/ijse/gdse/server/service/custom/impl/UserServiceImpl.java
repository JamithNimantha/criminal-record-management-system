package lk.ijse.gdse.server.service.custom.impl;

import lk.ijse.gdse.common.dto.UserDTO;
import lk.ijse.gdse.common.observer.Observer;
import lk.ijse.gdse.common.service.custom.UserService;
import lk.ijse.gdse.server.business.BusinessFactory;
import lk.ijse.gdse.server.business.custom.UserBusiness;
import lk.ijse.gdse.server.reservation.impl.ReservationsImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    private UserBusiness userBusiness = BusinessFactory.getInstance().getBussinessFor(BusinessFactory.BusinessTypes.USER);
    private static ArrayList<Observer> allUserObservers= new ArrayList<>();
    private static ReservationsImpl<UserService> userServiceReservations = new ReservationsImpl<>();

    public UserServiceImpl() throws RemoteException {

    }

    @Override
    public boolean addUser(UserDTO userDTO) throws Exception {
        notifyAllObservers(userDTO.getID()+"Is Added...!");
        return userBusiness.addUser(userDTO);
    }

    @Override
    public boolean updateUSer(UserDTO userDTO) throws Exception {
        if (userServiceReservations.reserve(userDTO.getID(),this,true)){
            boolean updateUser = userBusiness.updateUser(userDTO);
            if (updateUser){
                if (userServiceReservations.checkState(userDTO.getID(),this)){
                    userServiceReservations.release(userDTO.getID(),this);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) throws Exception {
        if (userServiceReservations.reserve(userDTO.getID(),this,true)){
            boolean deleteUser = userBusiness.deleteUser(userDTO);
            if (deleteUser){
                if (userServiceReservations.checkState(userDTO.getID(),this)){
                    userServiceReservations.release(userDTO.getID(),this);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public UserDTO searchUser(String id) throws Exception {
        return userBusiness.searchUser(id);
    }

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        return userBusiness.getAllUsers();
    }

    @Override
    public void register(Observer observer) throws Exception {
         allUserObservers.add(observer);

    }

    @Override
    public void unregister(Observer observer) throws Exception {
        allUserObservers.remove(observer);
    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
        for (Observer allObserver : allUserObservers){
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
        return userServiceReservations.reserve(id,this,true);
    }

    @Override
    public boolean released(Object id) throws Exception {
        return userServiceReservations.release(id,this);
    }
}
