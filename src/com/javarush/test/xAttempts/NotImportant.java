package com.javarush.test.xAttempts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ������� on 25.10.2015.
 */
public class NotImportant
{
    public static class C<T> {
        private T x;
        public C(Class<T> type) {
            try {
                if(type == Integer.class)
                    System.out.println("int");
                Integer.class.newInstance();
                x = type.newInstance();
            } catch (InstantiationException e) {
                System.out.println("cant create: " + type.getSimpleName());
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        AtomicInteger a = new AtomicInteger(3);
        a.incrementAndGet();
        System.out.println(a);
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        for(Map.Entry<String, String> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        Object o = null;
        String s = (String) o;

        System.out.println(String.format("date_bot_%03d", 10));
        String message = "bot: lalkaString";
        String userName = message.substring(0, message.indexOf(": "));
        String data = message.substring(message.indexOf(": ") + 2);
        System.out.println(userName);
        System.out.println(data);

        userName = "Bot";
        String answerFormat = "MMMM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(answerFormat);
        Calendar calendar = new GregorianCalendar();
        String resultText = "Информация для " + userName + ": "
                + dateFormat.format(calendar.getTime());
        System.out.println(resultText);
    }

}
