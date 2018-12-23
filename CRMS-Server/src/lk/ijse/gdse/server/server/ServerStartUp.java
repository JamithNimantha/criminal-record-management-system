package lk.ijse.gdse.server.server;

import lk.ijse.gdse.server.service.impl.ServiceFactoryImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerStartUp {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.rebind("CRMS", ServiceFactoryImpl.getInstance());
            System.out.println("Server has been Started...!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
