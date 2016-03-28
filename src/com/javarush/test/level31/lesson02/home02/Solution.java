package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        LinkedBlockingQueue<File> queue = new LinkedBlockingQueue<>();
        List<String> resultList = new ArrayList<>();

        queue.add(new File(root));
        File dir;
        while((dir = queue.poll()) != null) {
            List<File> currentDirList = new ArrayList<>();
            currentDirList.addAll(Arrays.asList(dir.listFiles()));
            for(File file: currentDirList) {
                if(file.isDirectory()) {
                    queue.add(file);
                } else {
                    resultList.add(file.getAbsolutePath());
                }
            }
        }
        return resultList;
    }
}
