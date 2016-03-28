package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import static com.javarush.test.level30.lesson15.big01.MessageType.*;

/**
 * Created by Аркадий on 11.03.2016.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public void run() {
        synchronized (this) {
            SocketThread socketThread = getSocketThread();
            socketThread.setDaemon(true);
            socketThread.start();
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Waiting for connection was interrupted!");
                return;
            }
            if(clientConnected) {
                ConsoleHelper.writeMessage("Соединение установлено. " +
                        "Для выхода наберите команду 'exit'.");
            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
                return;
            }
            while(true) {
                String text = ConsoleHelper.readString();
                if(text.equals("exit")) break;
                if (shouldSentTextFromConsole()) {
                    sendTextMessage(text);
                }
            }
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter server address, please:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter server port, please:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter your name, please:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        Message message = new Message(TEXT, text);
        try {
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error occurred while sending text message!");
            clientConnected = false;
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        @Override
        public void run() {
            try {
                String serverAddress = getServerAddress();
                int serverPort = getServerPort();
                Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while(true) {
                Message receiveMessage = connection.receive();
                switch(receiveMessage.getType()) {
                    case NAME_REQUEST:
                        String userName = getUserName();
                        Message userNameMessage = new Message(USER_NAME, userName);
                        connection.send(userNameMessage);
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message receivedMessage = connection.receive();
                String messageData = receivedMessage.getData();
                switch(receivedMessage.getType()) {
                    case TEXT:
                        processIncomingMessage(messageData);
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(messageData);
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(messageData);
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " joined chat.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " left chat.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }
    }
}
