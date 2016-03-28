package com.javarush.test.NetCraker.JavaAPI.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by Аркадий on 06.12.2015.
 */
public class ReflectionsImpl implements Reflections {
    @Override
    public Object getFieldValueByName(Object object, String fieldName) throws NoSuchFieldException {
        if(object == null || fieldName == null) {
            throw new NullPointerException();
        }
        Class c = object.getClass();
        Field field = c.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object result = null;
        try {
            result = field.get(object);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Set<String> getProtectedMethodNames(Class clazz) {
        if(clazz == null) {
            throw new NullPointerException();
        }
        Method[] methods = clazz.getDeclaredMethods();
        Set<String> result = new HashSet<>();
        for(Method method: methods) {
            int mods = method.getModifiers();
            if(Modifier.isProtected(mods)) {
                result.add(method.getName());
            }
        }
        return result;
    }

    @Override
    public Set<Method> getAllImplementedMethodsWithSupers(Class clazz) {
        if(clazz == null) {
            throw new NullPointerException();
        }
        Set<Method> result = new HashSet<>();
        result.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        while(true) {
            clazz = clazz.getSuperclass();
            if(clazz.getSimpleName().equals("Object")) {
                result.addAll(Arrays.asList(clazz.getDeclaredMethods()));
                return result;
            }
            result.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        }
    }

    @Override
    public List<Class> getExtendsHierarchy(Class clazz) {
        if(clazz == null) {
            throw new NullPointerException();
        }
        List<Class> result = new ArrayList<>();
        while(true) {
            clazz = clazz.getSuperclass();
            if(clazz.getSimpleName().equals("Object")) {
                result.add(clazz);
                return result;
            }
            result.add(clazz);
        }
    }

    @Override
    public Set<Class> getImplementedInterfaces(Class clazz) {
        if(clazz == null) {
            throw new NullPointerException();
        }
        Set<Class> result = new HashSet<>();
        result.addAll(Arrays.asList(clazz.getInterfaces()));
        return result;
    }

    @Override
    public List<Class> getThrownExceptions(Method method) {
        List<Class> result = new ArrayList<>();
        result.addAll(Arrays.asList(method.getExceptionTypes()));
        return result;
    }

    @Override
    public String getFooFunctionResultForDefaultConstructedClass() {
        try {
            Constructor defCon = SecretClass.class.getDeclaredConstructor();
            defCon.setAccessible(true);
            SecretClass sc = (SecretClass) defCon.newInstance();
            Method methodFoo = SecretClass.class.getDeclaredMethod("foo");
            methodFoo.setAccessible(true);
            return (String) methodFoo.invoke(sc);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getFooFunctionResultForClass(String constructorParameter, String string, Integer... integers) {
        try {
            Constructor defCon = SecretClass.class.getDeclaredConstructor(String.class);
            defCon.setAccessible(true);
            SecretClass sc = (SecretClass) defCon.newInstance(constructorParameter);
            Method methodFoo = SecretClass.class.getDeclaredMethod("foo", String.class, integers.getClass());
            methodFoo.setAccessible(true);
            return (String) methodFoo.invoke(sc, string, integers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
