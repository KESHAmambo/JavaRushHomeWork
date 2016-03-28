package com.javarush.test.xAttempts;

import java.lang.reflect.Method;

/**
 * Created by ������� on 27.04.2015.
 */
public class Trying
{
    public static void main(String[] arg) throws Exception
    {
        Trying attempt = new Trying();
        TryIn bas = attempt.new TryIn(3, 3);
        bas.a = 6;
        bas.b = 1;
        System.out.println(bas.a + " " + bas.b);
        System.out.println(bas.getReference().getClass().getName());

        // how to know if object has method
        Method methodToFind = bas.getClass().getMethod("getStr", (Class<?>[]) null);
        String s = (String) methodToFind.invoke(bas, (Object[]) null);
        System.out.println(s);
        System.out.println(Integer.toBinaryString(4));
    }

    class TryIn
    {
        private int a;
        public int b;
        public TryIn(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
        public Trying getReference()
        {
            return Trying.this;
        }
        public String getStr()
        {
            return "getStr()";
        }
    }

    static class A {
        static void getMe() {

        }
    }

    static class B extends A {
        public static void getMe(){

        }
    }
}
