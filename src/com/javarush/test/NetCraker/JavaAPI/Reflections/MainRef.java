package com.javarush.test.NetCraker.JavaAPI.Reflections;

import java.lang.reflect.Method;
import java.util.InvalidPropertiesFormatException;

/**
 * Created by Аркадий on 06.12.2015.
 */
public class MainRef
{
    public static void main(String[] args) throws Exception
    {
        Reflections.SecretClass sc = new Reflections.SecretClass("Test text.");
        Reflections ref = new ReflectionsImpl();
        System.out.println(ref.getFieldValueByName(sc, "secret"));
        System.out.println(ref.getFieldValueByName(sc, "text"));
        Class clazz = Reflections.SecretClass.class;
        System.out.println(ref.getProtectedMethodNames(clazz));
        System.out.println(clazz.getSuperclass().getSimpleName());
        for(Method method: ref.getAllImplementedMethodsWithSupers(clazz)) {
            System.out.println(method.getName());
        }
        System.out.println("Superclasses: " + ref.getExtendsHierarchy(clazz));
        System.out.println("Interfaces: " + ref.getImplementedInterfaces(clazz));
        A a = new A();
        System.out.println("Exceptions: " + ref.getThrownExceptions(a.getClass().getDeclaredMethod("method2")));
        System.out.println("Foo(default): " + ref.getFooFunctionResultForDefaultConstructedClass());
        System.out.println("Foo(redefined): " + ref.getFooFunctionResultForClass("Lalka", "Some original text.", 10, 30));
    }

    static class A
    {
        public void method1()
                throws NullPointerException, InvalidPropertiesFormatException {
        }
        private void method2() throws ArrayIndexOutOfBoundsException {
        }
        protected void method3(String s)
        {
            System.out.println(s);
        }
    }
}
