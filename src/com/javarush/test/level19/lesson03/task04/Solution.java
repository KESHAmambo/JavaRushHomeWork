package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scan;
        public PersonScannerAdapter(Scanner scan)
        {
            this.scan = scan;
        }

        @Override
        public Person read() throws IOException
        {
            String s = scan.nextLine();
            String[] data = s.split(" ");
            int year = Integer.parseInt(data[5]);
            int month = Integer.parseInt(data[4]) - 1;
            int day = Integer.parseInt(data[3]);
            Calendar cal = new GregorianCalendar(year, month, day);
            return new Person(data[1], data[2], data[0], cal.getTime());
        }

        @Override
        public void close() throws IOException
        {
            scan.close();
        }
    }
}
