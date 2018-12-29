package lk.ijse.gdse.server.business.custom.impl;

import lk.ijse.gdse.common.dto.UserDTO;
import lk.ijse.gdse.server.business.custom.UserBusiness;
import lk.ijse.gdse.server.common.IDGenerator;
import lk.ijse.gdse.server.entity.User;
import lk.ijse.gdse.server.repository.RepoFactory;
import lk.ijse.gdse.server.repository.custom.UserRepo;
import lk.ijse.gdse.server.resources.HibUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.BlobProxy;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class UserBusinessImpl implements UserBusiness {
    UserRepo userRepo = RepoFactory.getInstance().RepoFactoryFor(RepoFactory.RepoTypes.USER);

    @Override
    public boolean addUser(UserDTO userDTO) throws Exception {
        boolean response;
        try (Session openSession = HibUtil.getSessionFactory().openSession()) {
            userRepo.setSession(openSession);
            openSession.getTransaction().begin();
            response = userRepo.add(
                    new User(
                            userDTO.getID(),
                            userDTO.getName(),
                            userDTO.getPosition(),
                            userDTO.getPermissionLevel(),
                            userDTO.getDepartment(),
                            userDTO.getAddress(),
                            userDTO.getEmail(),
                            userDTO.getTelphone(),
                            userDTO.getPassword(),
                            BlobProxy.generateProxy(userDTO.getPhoto())
                    ));
            openSession.getTransaction().commit();
           // openSession.close();
        }
        return response;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) throws Exception {
        boolean response;
        try (Session opSession = HibUtil.getSessionFactory().openSession()) {
            userRepo.setSession(opSession);
            opSession.getTransaction().begin();
            response = userRepo.update(
                    new User(
                            userDTO.getID(),
                            userDTO.getName(),
                            userDTO.getPosition(),
                            userDTO.getPermissionLevel(),
                            userDTO.getDepartment(),
                            userDTO.getAddress(),
                            userDTO.getEmail(),
                            userDTO.getTelphone(),
                            userDTO.getPassword(),
                            BlobProxy.generateProxy(userDTO.getPhoto())
                    ));
            opSession.getTransaction().commit();
           // opSession.close();
        }
        return response;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) throws Exception {
        boolean response;
        try (Session opSession = HibUtil.getSessionFactory().openSession()) {
            userRepo.setSession(opSession);
            opSession.getTransaction().begin();
            response = userRepo.delete(
                    new User(
                            userDTO.getID(),
                            userDTO.getName(),
                            userDTO.getPosition(),
                            userDTO.getPermissionLevel(),
                            userDTO.getDepartment(),
                            userDTO.getAddress(),
                            userDTO.getEmail(),
                            userDTO.getTelphone(),
                            userDTO.getPassword(),
                            BlobProxy.generateProxy(userDTO.getPhoto())
                    ));
            opSession.getTransaction().commit();
           // opSession.close();
        }
        return response;
    }

    @Override
    public UserDTO searchUser(String id) throws Exception {
        User user;
        try (Session opSession = HibUtil.getSessionFactory().openSession()) {
            userRepo.setSession(opSession);
            opSession.getTransaction().begin();
            user = userRepo.search(id);
            opSession.getTransaction().commit();
           // opSession.close();
        }
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getPosition(),
                user.getPermission_level(),
                user.getDepartment(),
                user.getAddress(),
                user.getEmail(),
                user.getTelphone(),
                user.getPassword(),
                //user.getPhoto().getBytes()
                user.getPhoto().getBytes(1,(int)user.getPhoto().length())
        );
    }

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        List<UserDTO> userDTOS;
        try (Session openSession = HibUtil.getSessionFactory().openSession()) {
            userRepo.setSession(openSession);
            openSession.getTransaction().begin();
            userDTOS = new ArrayList<>();
            List<User> all = userRepo.getAll();
            for (User user : all) {
                userDTOS.add(
                        new UserDTO(
                                user.getId(),
                                user.getName(),
                                user.getPosition(),
                                user.getPermission_level(),
                                user.getDepartment(),
                                user.getAddress(),
                                user.getEmail(),
                                user.getTelphone(),
                                user.getPassword(),
                                user.getPhoto().getBytes(1, (int) user.getPhoto().length())
                                //IOUtils.
                                //BlobProxy.generateProxy(user.getPhoto())

                        ));
            }
            openSession.getTransaction().commit();
        }
        return userDTOS;
    }
}
