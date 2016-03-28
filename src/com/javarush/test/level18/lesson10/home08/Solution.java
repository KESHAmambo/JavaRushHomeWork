package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while(true)
        {
            String name = reader.readLine();
            if(name.equals("exit"))
                break;
            list.add(name);
        }
        for(String s: list)
        {
            ReadThread rt = new ReadThread(s);
            rt.start();
            rt.join();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);//implement constructor body
        }

        public void run()
        {
            try
            {
                int[] array = new int[2000];
                FileInputStream inputStream = new FileInputStream(getName());
                while(inputStream.available() > 0)
                {
                    int data = inputStream.read();
                    array[data]++;
                }
                int frequent = 0;
                int counter = array[0];
                for(int i = 1; i < array.length; i++)
                    if(array[i] >= counter)
                    {
                        frequent = i;
                        counter = array[i];
                    }
                resultMap.put(getName(), frequent);
                inputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }// implement file reading here - реализуйте чтение из файла тут
    }
}
