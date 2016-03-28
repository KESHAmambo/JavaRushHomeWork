package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
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

            JavaRush javaRush = new JavaRush();

            User user1 = new User();
            user1.setFirstName("Arkady");
            user1.setLastName("Baranok");
            user1.setBirthDate(new GregorianCalendar(1996, 5, 12).getTime());
            user1.setCountry(User.Country.RUSSIA);
            user1.setMale(true);
            User user2 = new User();
            user2.setFirstName("Valentina");
            user2.setLastName("Cuvaldova");
            user2.setBirthDate(new GregorianCalendar(1997, 4, 27).getTime());
            user2.setCountry(User.Country.RUSSIA);
            user2.setMale(false);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            for(User user: loadedObject.users)
            {
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(user.getBirthDate());
                System.out.println(user.getCountry());
                System.out.println(user.isMale());
            }

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

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            for(User user: users)
            {
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());
                printWriter.println(user.getBirthDate().getTime());
                printWriter.println(user.getCountry().getDisplayedName());
                printWriter.println(user.isMale());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            Scanner scan = new Scanner(inputStream);
            while(scan.hasNext())
            {
                User user = new User();
                user.setFirstName(scan.nextLine());
                user.setLastName(scan.nextLine());
                user.setBirthDate(new Date(Long.parseLong(scan.nextLine())));
                String temp = scan.nextLine();
                switch (temp)
                {
                    case "Russia":
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    case "Ukraine":
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    case "Other":
                        user.setCountry(User.Country.OTHER);
                        break;
                }
                user.setMale(Boolean.parseBoolean(scan.nextLine()));
                users.add(user);
            }
            scan.close();
        }
    }
}
