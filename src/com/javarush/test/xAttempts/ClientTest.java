package com.javarush.test.xAttempts;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Аркадий on 12.03.2016.
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.72", 4000);
        System.out.println("All right!!!");
    }
}
