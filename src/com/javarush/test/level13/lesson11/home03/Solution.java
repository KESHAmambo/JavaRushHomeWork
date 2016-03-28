package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream file = new FileInputStream(reader.readLine());
        //InputStream inStream = file;

        while(file.available() > 0) //while(inStream.available() > 0)
            System.out.print((char)file.read());//System.out.println((char)inStream.read();

        //inStream.close();
        file.close();
    }
}
