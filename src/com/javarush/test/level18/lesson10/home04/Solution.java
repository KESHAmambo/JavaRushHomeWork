package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(name1);
        FileInputStream inputStream2 = new FileInputStream(name2);
        byte[] buffer1 = new byte[inputStream1.available()];
        byte[] buffer2 = new byte[inputStream2.available()];
        inputStream1.read(buffer1);
        inputStream2.read(buffer2);
        inputStream1.close();
        inputStream2.close();
        FileOutputStream outputStream = new FileOutputStream(name1);
        outputStream.write(buffer2);
        outputStream.write(buffer1);
        outputStream.close();
        reader.close();
    }
}
