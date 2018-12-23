package lk.ijse.gdse.server.repository;

import java.util.List;

public interface CrudRepository <T,ID> extends SuperRepository {
    public boolean add(T enity) throws Exception;
    public boolean delete(T entity) throws Exception;
    public boolean update(T entity) throws Exception;
    public  T search(ID id) throws Exception;
    public List<T> getAll() throws Exception;
}
