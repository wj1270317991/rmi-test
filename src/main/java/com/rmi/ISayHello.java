package com.rmi;

import java.rmi.Remote;

public interface ISayHello extends Remote {

    String syaHello(String name) throws java.rmi.RemoteException;

}
