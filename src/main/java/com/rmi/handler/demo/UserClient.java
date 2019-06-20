package com.rmi.handler.demo;

import java.io.IOException;

public class UserClient extends User {

    public static void main(String[] args) throws IOException {
        User user_stub = new User_Stub();
        System.out.println(user_stub.getAge());
    }
}
