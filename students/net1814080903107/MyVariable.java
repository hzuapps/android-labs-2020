package com.example.thefirst;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

class MyVariable {
    private String sIP="10.77.26.235";//"10.77.26.225"
    private final int sPort=20002;//serverPort
    private InetAddress inetAddress;
    public MyVariable(){
        try {
            inetAddress = InetAddress.getByName(sIP);
        }catch (IOException ex){}
    }
    public InetAddress getsIP() {
        return inetAddress;
    }
    public int getsPort() {
        return sPort;
    }

}

