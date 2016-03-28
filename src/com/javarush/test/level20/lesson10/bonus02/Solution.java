package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;
import java.util.Arrays;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        ArrayList<Integer[]> list = new ArrayList<>();

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                if(a[i][j] == 1) {
                    boolean added = false;
                    for(Integer[] array: list) {
                        if(i >= array[0] && j >= array[1] && i <= array[2] && j <= array[3]) {
                            added = true;
                            break;
                        }
                    }
                    if(!added) {
                        int c1 = i;
                        int c2 = j;
                        while(true) {
                            try {
                                c1++;
                                if (a[c1][j] == 0)
                                {
                                    c1--;
                                    break;
                                }
                            }catch(ArrayIndexOutOfBoundsException e) {
                                c1--;
                                break;
                            }
                        }
                        while(true) {
                            try {
                                c2++;
                                if(a[i][c2] == 0)
                                {
                                    c2--;
                                    break;
                                }
                            }catch(ArrayIndexOutOfBoundsException e) {
                                c2--;
                                break;
                            }
                        }
                        Integer[] newRec = new Integer[]{i, j, c1, c2};
                        list.add(newRec);
                    }
                }
            }
        }
        return list.size();
    }
}