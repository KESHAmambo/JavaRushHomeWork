package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        Solution n = (Solution) o;
        if(first == null ? n.first != null : !first.equals(n.first))
            return false;
        return last == null ? n.last == null : last.equals(n.last);
    }

    public int hashCode()
    {
        int result = first != null ? first.hashCode() : 0;
        result = result * 31 + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution(null, "lalka")));
    }
}
