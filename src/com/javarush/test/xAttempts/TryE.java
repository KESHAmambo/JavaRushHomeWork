package com.javarush.test.xAttempts;

/**
 * Created by ������� on 18.10.2015.
 */
public class TryE
{
    static void get(){}
    public static class A
    {
        String x = "X";
        private A(){}
        static void get(String a, int b) {

        }
    }

    static class B extends A implements C
    {
        public B() {

        }
        static void get(String a, int b){}
    }

    interface C
    {
        String x = "C";
    }

    public static void main(String[] args)
    {

        /*
        Collection<Integer> col = new ArrayList();
        col.addAll(Arrays.asList(1, 2, 3, 4, 5));
        Collections.addAll(col, null, null);
        System.out.println(col);
        try {
            return;
        } catch(Exception e)
        {
            System.out.println(2);
        } finally {
            System.out.println(3);
        }
        System.out.println(4);*/
    }
}
