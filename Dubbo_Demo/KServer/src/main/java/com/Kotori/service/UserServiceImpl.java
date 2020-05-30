package com.Kotori.service;

public class UserServiceImpl implements UserService {

    private int port;

    public void setPort(int port) {
        this.port = port;
    }

    public void doSomething() {
        System.out.println("doSomething-------port=" + port);
    }
}
