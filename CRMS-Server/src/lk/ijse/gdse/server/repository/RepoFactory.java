package lk.ijse.gdse.server.repository;

import lk.ijse.gdse.server.repository.custom.impl.CriminalRepoImpl;
import lk.ijse.gdse.server.repository.custom.impl.RecordRepoImpl;
import lk.ijse.gdse.server.repository.custom.impl.UserRepoImpl;

public class RepoFactory {
    private static RepoFactory repoFactory;

    public static RepoFactory getInstance() {
        if (repoFactory==null){
            repoFactory=new RepoFactory();
        }
        return repoFactory;

    }
    public enum RepoTypes{
        USER,RECORD,CRIMINAL;
    }

    public<T>T RepoFactoryFor(RepoTypes repoTypes) {
        switch (repoTypes) {
            case USER:
                return (T) new UserRepoImpl();
            case RECORD:
                return (T) new RecordRepoImpl();
            case CRIMINAL:
                return (T) new CriminalRepoImpl();
            default:
                return null;
        }
    }
}
