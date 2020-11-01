package com.example.thefirst;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

class MyVariable {
    private  InetAddress sIP;//serverIP
    private  final int sPort=20002;//serverPort
    MyVariable(){
        try {
            sIP = InetAddress.getByName("10.77.26.225");
        }catch (IOException ex){}
    }
    public InetAddress getsIP() {
        return sIP;
    }
    public int getsPort() {
        return sPort;
    }

}
