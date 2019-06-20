package com.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {

    public static void main(String[] args) {
        try {
            Object iSayHello  = Naming.lookup("rmi://localhost:8888/sayHello");
            System.out.println(iSayHello);
            System.out.println(((ISayHello)iSayHello).syaHello("jack"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
