package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Аркадий on 11.03.2016.
 */
public class BotClient extends Client {
    private static volatile int count = 0;

    @Override
    protected String getUserName() {
        if(count == 99) count = 0;
        return String.format("date_bot_%02d", count++);
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: " +
                    "дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if(!message.contains(": ")) return;

            String userName = message.substring(0, message.indexOf(": "));
            String data = message.substring(message.indexOf(": ") + 2);
            ConsoleHelper.writeMessage(data);
            String answerFormat = getAnswerFormat(data);
            if(answerFormat != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(answerFormat);
                Calendar calendar = new GregorianCalendar();
                String resultText = "Информация для " + userName + ": "
                        + dateFormat.format(calendar.getTime());
                sendTextMessage(resultText);
            }
        }

        private String getAnswerFormat(String data) {
            switch(data) {
                case "дата":
                    return "d.MM.YYYY";
                case "день":
                    return "d";
                case "месяц":
                    return "MMMM";
                case "год":
                    return "YYYY";
                case "время":
                    return "H:mm:ss";
                case "час":
                    return "H";
                case "минуты":
                    return "m";
                case "секунды":
                    return "s";
                default:
                    return null;
            }
        }
    }
}
