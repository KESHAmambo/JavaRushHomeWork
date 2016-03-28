package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Аркадий on 10.03.2016.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for(Map.Entry<String, Connection> pair: connectionMap.entrySet()) {
            Connection connection = pair.getValue();
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Couldn't sent message to " + pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        int serverPort = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(serverPort, 10, InetAddress.getByName("192.168.1.72"));) {
            ConsoleHelper.writeMessage("Server is started.");
            while(true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Established a remote connection to address: "
                    + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                Message userAddedMessage = new Message(MessageType.USER_ADDED, userName);
                sendBroadcastMessage(userAddedMessage);
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("ERROR occurred while working with remote address!");
            } finally {
                if(userName != null) {
                    connectionMap.remove(userName);
                    Message messageToSend = new Message(MessageType.USER_REMOVED, userName);
                    sendBroadcastMessage(messageToSend);
                }
            }
            ConsoleHelper.writeMessage("Remote connection was closed: " + socket.getRemoteSocketAddress());
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            label: while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message userNameMessage = connection.receive();
                if(userNameMessage.getType() == MessageType.USER_NAME) {
                    String userName = userNameMessage.getData();
                    if(userName == null || userName.isEmpty()) {
                        continue;
                    }
                    for(String existedName: connectionMap.keySet()) {
                        if(existedName.equals(userName)) {
                            continue label;
                        }
                    }
                    connectionMap.put(userName, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return userName;
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for(String existedName: connectionMap.keySet()) {
                if(!existedName.equals(userName)) {
                    Message message = new Message(MessageType.USER_ADDED, existedName);
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while(true) {
                Message message = connection.receive();
                if(message.getType() != MessageType.TEXT) {
                    System.out.println("ERROR: not a TEXT message!");
                    continue;
                }
                Message messageToSend = new Message(MessageType.TEXT, userName + ": " + message.getData());
                sendBroadcastMessage(messageToSend);
            }
        }
    }
}
