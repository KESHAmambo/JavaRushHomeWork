package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) {
//        args = new String[] {"c:/javaidea/test/dir", "c:/javaidea/test/result.txt"};
        try {
            File resultFile = new File(args[1]);
            List<File> list = getFileAndDirTree(args[0]);

            Iterator<File> iterator = list.iterator();
            while(iterator.hasNext()) {
                File file = iterator.next();
                if (!file.isDirectory() && file.length() > 50) {
                    iterator.remove();
                    file.delete();
                }
            }

            Collections.sort(list, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            FileWriter fileWriter = new FileWriter(resultFile);
            char[] buf = new char[1024];
            FileReader fileReader;
            iterator = list.iterator();
            while(iterator.hasNext()) {
                File file = iterator.next();
                if(file.isDirectory()) continue;
                fileReader = new FileReader(file);
                int count;
                while (fileReader.ready()) {
                    count = fileReader.read(buf);
                    fileWriter.write(buf, 0, count);
                }
                if(iterator.hasNext()) {
                    fileWriter.write('\n');
                }
                fileReader.close();
            }
            fileWriter.close();

            while(!hasEmptyDir(args[0])) {
                iterator = list.iterator();
                while(iterator.hasNext()) {
                    File file = iterator.next();
                    if(file.isDirectory()) {
                        if(file.delete()) {
                            iterator.remove();
                        }
                    }
                }
            }

            File tempFile = new File(resultFile.getParent() + "/allFilesContent.txt");
            resultFile.renameTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<File> getFileAndDirTree(String root) throws IOException {
        LinkedBlockingQueue<File> queue = new LinkedBlockingQueue<>();
        List<File> resultList = new ArrayList<>();

        queue.add(new File(root));
        File dir;
        while((dir = queue.poll()) != null) {
            for(File file: Arrays.asList(dir.listFiles())) {
                resultList.add(file);
                if(file.isDirectory()) queue.add(file);
            }
        }
        return resultList;
    }

    private static boolean hasEmptyDir(String root) throws IOException {
        List<File> list = getFileAndDirTree(root);
        for(File file: list) {
            if(file.isDirectory()) {
                if (file.list().length == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
