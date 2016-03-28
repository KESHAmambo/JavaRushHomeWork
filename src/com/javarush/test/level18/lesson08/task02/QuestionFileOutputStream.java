package com.javarush.test.level18.lesson08.task02;

import java.io.*;
import java.util.Scanner;

/* Расширяем AmigoOutputStream
Используя шаблон проектирования Wrapper (Decorator) расширьте функциональность AmigoOutputStream
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу [Вы действительно хотите закрыть поток? Д/Н]
2. Считайте строку
3. Если считанная строка равна [Д], то закрыть поток
4. Если считанная строка не равна [Д], то не закрывать поток
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream original)
    {
        this.original = original;
    }

    public void flush() throws IOException
    {
        original.flush();
    }

    public void write(int b) throws IOException
    {
        original.write(b);
    }

    public void write(byte[] b) throws IOException
    {
        original.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException
    {
        original.write(b, off, len);
    }

    public void close() throws IOException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if(scan.nextLine().equals("Д"))
            original.close();
        scan.close();
    }
}

