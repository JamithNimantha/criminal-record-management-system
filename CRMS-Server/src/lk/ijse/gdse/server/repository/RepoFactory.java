package lk.ijse.gdse.server.repository;

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
        USER;
    }

    public<T>T RepoFactoryFor(RepoTypes repoTypes) {
        switch (repoTypes) {
            case USER:
                return (T) new UserRepoImpl();
            default:
                return null;
        }
    }
}
