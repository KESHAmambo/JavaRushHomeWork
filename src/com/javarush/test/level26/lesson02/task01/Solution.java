package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        double m = 0;
        Collections.sort(Arrays.asList(array));
        if(array.length % 2 == 1) {
            m = array[array.length / 2];
        } else {
            m = ((double) array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        }
        final double median = m;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                double result = Math.abs(median - i1) - Math.abs(median - i2);
                if(result > 0) {
                    return 1;
                }
                else if(result < 0) {
                    return -1;
                }
                else {
                    if(i2 > i1) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        };
        Collections.sort(Arrays.asList(array), comparator);
        return array;
    }
}
