package lk.ijse.gdse.server.business.custom;

import lk.ijse.gdse.common.dto.UserDTO;
import lk.ijse.gdse.server.business.SuperBusiness;

import java.util.List;

public interface UserBusiness extends SuperBusiness {
    public boolean addUser(UserDTO userDTO) throws Exception;
    public boolean updateUser(UserDTO userDTO) throws Exception;
    public boolean deleteUser(UserDTO userDTO) throws Exception;
    public UserDTO searchUser(String id) throws Exception;
    public List<UserDTO> getAllUsers() throws Exception;
}
