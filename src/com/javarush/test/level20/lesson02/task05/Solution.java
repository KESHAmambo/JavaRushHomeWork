package com.javarush.test.level20.lesson02.task05;

import java.io.*;
import java.util.Scanner;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("c:/JavaIDEA/try.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            loadedObject.string1.print();
            loadedObject.string2.print();
            System.out.println(countStrings);//check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception
        {
            PrintStream consoleStream = System.out;
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            PrintStream temp = new PrintStream(arrayOutputStream);
            System.setOut(temp);
            string1.print();
            string2.print();
            java.lang.String result = arrayOutputStream.toString();
            System.setOut(consoleStream);
            temp.close();

            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print(result);
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            Scanner scan = new Scanner(inputStream);
            java.lang.String s1 = scan.nextLine();
            java.lang.String s2 = scan.nextLine();
            int index1 = s1.indexOf('#') + 1;
            int index2 = s2.indexOf('#') + 1;
            int dig1 = Integer.parseInt(s1.substring(index1));
            int dig2 = Integer.parseInt(s2.substring(index2));
            int temp = countStrings;
            countStrings = dig1 - 1;
            string1 = new String();
            countStrings = dig2 - 1;
            string2 = new String();
            countStrings = temp;
            scan.close();
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
