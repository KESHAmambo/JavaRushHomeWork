package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        clone = solution.clone();
        System.out.println(solution);
        System.out.println(clone);

        System.out.println(solution.users);
        System.out.println(clone.users);
    }

    protected Map<String, User> users = new LinkedHashMap();

    public Solution clone()
    {
        Solution result = new Solution();
        for(Map.Entry<String, User> pair: users.entrySet())
        {
            User user = new User(pair.getValue().age, pair.getValue().name);
            result.users.put(pair.getKey(), user);
        }
        return result;
    }

    public static class User {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}