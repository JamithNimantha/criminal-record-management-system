package lk.ijse.gdse.client.proxy;

import lk.ijse.gdse.common.service.ServiceFactory;
import lk.ijse.gdse.common.service.custom.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProxyHandler implements ServiceFactory {

    private static ProxyHandler proxyHandler;
    private UserService userService;


    public static ProxyHandler getInstance(){
        if (proxyHandler==null){
            proxyHandler= new ProxyHandler();
        }
        return proxyHandler;
    }

    private ProxyHandler() {
        try {
            ServiceFactory serviceFactory = (ServiceFactory) Naming.lookup("rmi://127.0.0.1:5050/CRMS");
            userService = serviceFactory.getSuperService(ServiceTypes.USER);
        } catch (NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T getSuperService(ServiceTypes serviceTypes) throws Exception {
        switch (serviceTypes){
            case USER:
                return (T) userService;
                default:
                    return null;
        }
    }
}
