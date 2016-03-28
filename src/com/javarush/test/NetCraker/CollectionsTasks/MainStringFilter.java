package com.javarush.test.NetCraker.CollectionsTasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Аркадий on 14.11.2015.
 */
public class MainStringFilter
{
    public static void main(String[] args)
    {
        Set<String> set = new HashSet<>();
        set.add("lalka");
        set.add("palka");
        set.add("tvorog");
        set.add(null);
        //set.remove(null);
        System.out.println(Arrays.toString(set.toArray()));
        System.out.println(set.contains("palka"));
        boolean a = set.remove("palka");
        System.out.println(set.contains("palka") + " " + a);
        set.add(null);
        set.add(null);
        System.out.println(Arrays.toString(set.toArray()));
        set.clear();
        System.out.println(Arrays.toString(set.toArray()));
        String s = "Very long string.";
        System.out.println(s.toLowerCase().contains("very l"));
        System.out.println("starts: " + s.toLowerCase().startsWith(""));
        System.out.format("%d %d\n", (int) '0', (int) '9');
        s = "very*simple*to get the Moon*and*the Star!";
        System.out.println(s.indexOf("*"));
        System.out.println(s.substring(s.indexOf("*") + 1));
        System.out.println(s.indexOf("-"));
        final String pattern = "morozh";
        String temp = pattern;
        temp = temp.replace('m', 'D');
        System.out.println(temp);
        s = s.substring(s.indexOf("simple") + "simple".length());
        System.out.println(s);
        s = s.substring(s.indexOf("Moon") + "Moon".length());
        System.out.println(s);
        System.out.println("---------------------------------");
        StringFilter sf = new StringFilterImpl();

        sf.add("lalka is here");
        sf.add("i have no idea what to write there(sr).");
        sf.add("only an empty string.");
        sf.add("THat String is in Upper Case!");
        sf.add("Only best men can believe.");
        sf.add("(945)876-890");
        sf.add("1000");
        sf.add("1 111");
        sf.add("9000");
        sf.add("9 999");
        sf.add("(893)899-154");
        sf.add("(473)824-554");
        sf.add("( 43)849-234");
        sf.add("distribute");
        sf.add("diaaabuteaaaaaa");
        sf.add("istr");
        sf.add("istraaaaa");
        sf.add("diaaaabuDDDte");
        sf.add("Some text: str");
        sf.add("str - sm");
        sf.add("4831");
        sf.add("1 111");
        sf.add("1");
        sf.add("s akfalksdfj fakdfaoi t adfjakdfrrrrrakldf");
        sf.add(null);
        sf.add(null);
        sf.add(null);
        Iterator it = sf.getStringsByPattern("*1"); // (!str.isEmpty) equals (pattern.charAt(pattern.length() - 1) != '*')
        while(it.hasNext())
            System.out.println("RESULT: " + it.next());
    }
}
