package lk.ijse.gdse.server.repository;

import org.hibernate.Session;

public interface SuperRepository {
    public void setSession(Session session) throws Exception;
}
