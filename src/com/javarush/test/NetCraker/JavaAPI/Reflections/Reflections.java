package com.javarush.test.NetCraker.JavaAPI.Reflections;

/**
 * Created by ������� on 06.12.2015.
 */

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * ���� ������ - ��������� ��������� ���������� � ������� � ����������
 * � ����� � ������� �������� � ������� Reflection API.<br/>
 * �������������: ��������� ����������� ������ � ��������� (� Generics).<br/>
 * <br/>
 * �������<br/>
 * ����������� ������ ������� ���������� ����� ������ Reflection API
 *  (� ����������� ������� ����������� ������ � ����������� �������).<br/>
 *
 * @author Alexey Vasiliev
 * */
public interface Reflections {

    /**
     * ����� ���������� ������� �������� ���� ��� ������� ����������,
     * �������� ������������� private, public, protected ��� default.
     * @param object ��������� ������
     * @param fieldName ��� ���� ������
     * @throws NoSuchFieldException ���� ���� � ��������� ������ �� ����������
     * @throws NullPointerException ���� fieldName or object �������� null-��
     * @return ������� �������� ����
     * */
    public Object getFieldValueByName(Object object, String fieldName) throws NoSuchFieldException ;

    /**
     * ����� ���������� ����� ���� ������� ��� ������, ���������� ��������������� protected
     * @param clazz �����
     * @throws NullPointerException ���� clazz �������� null-��
     * @return ����� ���� �������
     * */
    public Set<String> getProtectedMethodNames(Class clazz);

    /**
     * ����� ���������� ����� ���� ������� ������, � �.�. ������� ��� ������������.
     * ������������ ������ ����� ����� ����� ������������.
     * ���� � �������� ���� ���������������� ������, ������ ������������ ��� ���
     *   (� �� ������ �����, ���������������� ���������).<br/>
     * @param clazz �����
     * @throws NullPointerException ���� clazz �������� null-��
     * @return ����� ������� ��� ���� �������� �������.
     * */
    public Set<Method> getAllImplementedMethodsWithSupers(Class clazz);

    /**
     * ����� ���������� ������ �������, ���������� ������������� ��� ���������� ������.
     * @param clazz �����
     * @throws NullPointerException ���� clazz �������� null-��
     * @return ����� ������� ���� ��������.
     * */
    public List<Class> getExtendsHierarchy(Class clazz);

    /**
     * ����� ���������� ������ �����������, ������� ��������� �����/��������� clazz
     * @param clazz - �����/���������
     * @throws NullPointerException - ���� clazz �������� null-��
     * @return ����� �����������
     * */
    public Set<Class> getImplementedInterfaces(Class clazz);


    /**
     * ����� ���������� ������ ����������, ������� ����� ��������� �����
     * @param method �����
     * @return ������ ����������� ����������
     * @throws NullPointerException ���� method �������� null-��
     * */
    public List<Class> getThrownExceptions(Method method);

    /**
     * ����� ������� ��������� ������ SecretClass � ������� ������������ �� ���������,
     * ����� ���� ������� ��� ����� foo()
     * @return ���������, ������� ���������� ����� foo()
     * */
    public String getFooFunctionResultForDefaultConstructedClass() ;

    /**
     * ����� ������� ��������� ������ SecretClass � ������� ������������ � ���������� constructorParameter
     * ����� ���� ������� ��� ����� foo(...), � ������� ���������� ��� �� ����� ����� ����������, ��� �������� �������
     * @param constructorParameter ��������, ������������ ������������
     * @param string ������ �������� ��� ������� foo
     * @param integers ����������� ��������� ��� ������� foo
     * @return ���������, ������� ���������� ����� foo(...)
     * */
    public String getFooFunctionResultForClass(String constructorParameter, String string, Integer ... integers);

    class SuperSecret {}
    interface firstInterface {}
    interface secondInterface {}

    @SuppressWarnings("unused")
    public class SecretClass extends SuperSecret
            implements firstInterface, secondInterface
    {
        private String text = null;

        private String secret = "secret";

        private SecretClass() {
        }

        public SecretClass(String text) {
            this.text = text;
        }

        public void setSecret (String secret) {
            this.secret = secret;
        }

        private String foo(String string, Integer ... integers){
            String s = "";
			/* Some text hidden : start */
            int in = 0;
            if(integers != null)
                for(Integer i : integers)
                    in += i;
            s += string + " - > " + in;
			/* Some text hidden : end */
            return s;
        }

        private String foo(){
            String s = "";
			/* Some text hidden : start */
            s += "abraKadabra";
			/* Some text hidden : end */
            return s;
        }

        protected void protectedMethod1() {}
        protected String protectedMethod2() {
            return "Some method2 text.";
        }
        public int hashCode() {
            return 0;
        }

    }

}
