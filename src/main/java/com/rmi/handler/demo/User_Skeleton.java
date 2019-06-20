package com.rmi.handler.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 服务端
 *
 * https://blog.csdn.net/qq_41517936/article/details/81015711
 */
public class User_Skeleton extends Thread {

    private UserServer userServer;

    public User_Skeleton(UserServer userServer) {
        this.userServer = userServer;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket =  new ServerSocket(8800);
            Socket accept = serverSocket.accept();
            while (accept != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                String method = bufferedReader.readLine();
                if (method.equals("age")){
                    int age = userServer.getAge();

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
                    objectOutputStream.writeInt(age);
                    objectOutputStream.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
