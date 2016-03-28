package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        load(inputStream);
        inputStream.close();
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for(Map.Entry<String, String> pair: properties.entrySet())
        {
            prop.setProperty(pair.getKey(), pair.getValue());
        }
        PrintWriter printWriter = new PrintWriter(outputStream);
        prop.store(printWriter, null);
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        for(Map.Entry<Object, Object> pair: prop.entrySet())
        {
            properties.put(pair.getKey().toString(), pair.getValue().toString());
        }
    }
}
