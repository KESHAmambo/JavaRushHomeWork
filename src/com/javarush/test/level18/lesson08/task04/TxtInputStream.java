package com.javarush.test.level18.lesson08.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws UnsupportedFileNameException, FileNotFoundException
    {
        super(fileName);
        int length = fileName.length();
        if(!(fileName.charAt(length - 1) == 't' && fileName.charAt(length - 2) == 'x' && fileName.charAt(length - 3) == 't' && fileName.charAt(length - 4) == '.'))
            throw new UnsupportedFileNameException();
    }

}

