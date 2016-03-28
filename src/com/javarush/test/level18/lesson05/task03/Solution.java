package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());
        int charNumber = inputStream.available();
        int half1 = charNumber / 2;
        int half2 = half1;
        if(charNumber % 2 == 1)
            half1++;
        byte[] buffer = new byte[half1];
        inputStream.read(buffer);
        outputStream1.write(buffer);
        buffer = new byte[half2];
        inputStream.read(buffer);
        outputStream2.write(buffer);
        inputStream.close();
        outputStream2.close();
        outputStream1.close();
    }
}
