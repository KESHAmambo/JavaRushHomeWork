package com.javarush.test.xAttempts;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Аркадий on 12.03.2016.
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4000, 10, InetAddress.getByName("192.168.1.72"));
        System.out.println(serverSocket.getInetAddress());
        serverSocket.accept();
        System.out.println("Connection accepted!");
        /*Socket socket = serverSocket.accept();
        System.out.println("Connection established: " + socket.getRemoteSocketAddress());
        System.out.println(serverSocket.getLocalSocketAddress());*/
    }
}
