package lk.ijse.gdse.common.service.custom;

import lk.ijse.gdse.common.dto.UserDTO;
import lk.ijse.gdse.common.observer.Observer;
import lk.ijse.gdse.common.observer.Subject;
import lk.ijse.gdse.common.reservation.Reservation;
import lk.ijse.gdse.common.service.SuperService;

import java.util.List;

public interface UserService extends SuperService, Reservation, Subject {
    public boolean addUser(UserDTO userDTO) throws Exception;
    public boolean updateUSer(UserDTO userDTO) throws Exception;
    public boolean deleteUser(UserDTO userDTO) throws Exception;
    public UserDTO searchUser(String id) throws Exception;
    public List<UserDTO> getAllUsers() throws Exception;
}
