package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String teg = "<" + args[0];// !!!
        String end = "</" + args[0] + ">";// !!!
        Scanner scan = new Scanner(new File(reader.readLine()));
        String text = "";
        while(scan.hasNext())
            text += scan.nextLine();

        while(text.contains(teg))
        {
            int index1 = text.indexOf(teg);
            text = text.substring(index1 + teg.length());
            int index2 = 0;
            int index3 = 0;
            while(true)
            {
                index2 = text.indexOf(teg, index2 + 1);
                index3 = text.indexOf(end, index3 + 1);
                if(index2 == -1 || index2 > index3)
                {
                    System.out.println(teg + text.substring(0, index3 + end.length()));
                    break;
                }
            }
        }
    }
}
