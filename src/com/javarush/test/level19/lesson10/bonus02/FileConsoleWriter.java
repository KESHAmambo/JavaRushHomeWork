package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(String file) throws IOException {
        super(file);
    }

    @Override
    public void write(char[] b) throws IOException
    {
        super.write(b);
    }

    @Override
    public void write(int b) throws IOException
    {
        System.out.print((char) b);
        super.write(b);
    }

    @Override
    public void write(String b) throws IOException
    {
        super.write(b);
    }

    @Override
    public void write(char[] array, int off, int len) throws IOException
    {
        for(int i = off; i < off + len; i++)
            System.out.print(array[i]);
        super.write(array, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        write(str.toCharArray(), off, len);
    }
}
