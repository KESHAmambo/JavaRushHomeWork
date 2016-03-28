package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same");
        for(Word w: list)
            System.out.println(w);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();

        //vertical
        int j = -1;
        while(true) {
            try {
                j++;
                String s = "";
                for (int[] aCrossword : crossword)
                    s += (char) aCrossword[j];

                for(String word: words) {
                    if(s.contains(word)) {
                        Word temp = new Word(word);
                        temp.setStartPoint(j, s.indexOf(word));
                        temp.setEndPoint(j, s.indexOf(word) + word.length() - 1);
                        list.add(temp);
                    }
                    String rev = new StringBuilder(s).reverse().toString();
                    if(rev.contains(word))
                    {
                        Word temp = new Word(word);
                        temp.setStartPoint(j, rev.length() - rev.indexOf(word) - 1);
                        temp.setEndPoint(j, rev.length() - rev.indexOf(word) - word.length());
                        list.add(temp);
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        //horizontal
        for (int i = 0; i < crossword.length; i++) {
            j = -1;
            String s = "";

            while (true) {
                try {
                    j++;
                    s += (char) crossword[i][j];
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }

            for(String word: words)
            {
                if(s.contains(word))
                {
                    Word temp = new Word(word);
                    temp.setStartPoint(s.indexOf(word), i);
                    temp.setEndPoint(s.indexOf(word) + word.length() - 1, i);
                    list.add(temp);
                }
                String rev = new StringBuilder(s).reverse().toString();
                if(rev.contains(word))
                {
                    Word temp = new Word(word);
                    temp.setStartPoint(rev.length() - rev.indexOf(word) - 1, i);
                    temp.setEndPoint(rev.length() - rev.indexOf(word) - word.length(), i);
                    list.add(temp);
                }
            }
        }

        //diagonal top
        j = -1;
        while(true) {
            j++;
            int jt = j;
            String s = "";
            int i = 0;
            while(true) {
                try {
                    s += (char) crossword[i][jt];
                    i++;
                    jt++;
                }catch(ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }

            for(String word: words)
            {
                if(s.contains(word))
                {
                    Word temp = new Word(word);
                    temp.setStartPoint(j + s.indexOf(word), s.indexOf(word));
                    temp.setEndPoint(j +  s.indexOf(word) + word.length() - 1, s.indexOf(word) + word.length() - 1);
                    list.add(temp);
                }
                String rev  = new StringBuilder(s).reverse().toString();
                if(rev.contains(word))
                {
                    Word temp = new Word(word);
                    temp.setStartPoint(j + rev.length() - 1 - rev.indexOf(word), rev.length() - 1 - rev.indexOf(word));
                    temp.setEndPoint(j + rev.length() - rev.indexOf(word) - word.length(), rev.length() - rev.indexOf(word) - word.length());
                    list.add(temp);
                }
            }
            if(s.length() == 1)
                break;
        }

        //diagonal bottom
        int i = 0;
        while(true) {
            i++;
            int it = i;
            String s = "";
            j = 0;
            while(true) {
                try {
                    s += (char) crossword[it][j];
                    it++;
                    j++;
                }catch(ArrayIndexOutOfBoundsException e){
                    break;
                }
            }

            for(String word: words)
            {
                if (s.contains(word))
                {
                    Word temp = new Word(word);
                    temp.setStartPoint(s.indexOf(word), i + s.indexOf(word));
                    temp.setEndPoint(s.indexOf(word) + word.length() - 1, i + s.indexOf(word) + word.length() - 1);
                    list.add(temp);
                }
                String rev = new StringBuilder(s).reverse().toString();
                if (rev.contains(word))
                {
                    Word temp = new Word(word);
                    temp.setStartPoint(rev.length() - 1 - rev.indexOf(word), i + rev.length() - 1 - rev.indexOf(word));
                    temp.setEndPoint(rev.length() - rev.indexOf(word) - word.length(), i + rev.length() - rev.indexOf(word) - word.length());
                    list.add(temp);
                }
            }
            if(s.length() == 1)
                break;
        }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
    /*

     */
}
