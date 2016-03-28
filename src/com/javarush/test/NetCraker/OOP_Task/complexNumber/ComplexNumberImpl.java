package com.javarush.test.NetCraker.OOP_Task.complexNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Аркадий on 10.10.2015.
 */
public class ComplexNumberImpl implements ComplexNumber
{
    private Double re;
    private Double im;

    public ComplexNumberImpl() {
        re = 0.0;
        im = 0.0;
    }

    @Override
    public double getRe()
    {
        return re;
    }

    @Override
    public double getIm()
    {
        return im;
    }

    @Override
    public boolean isReal()
    {
        return im == 0;
    }

    @Override
    public void set(double re, double im)
    {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException
    {
        try
        {
            boolean full = false;
            boolean real = false;

            if (value.indexOf('-', 1) != -1 || value.indexOf('+', 1) != -1)
                full = true;
            else if (value.indexOf('i') == -1)
                real = true;

            if (full)
            {
                String reVal;
                String imVal;
                if (value.indexOf('-', 1) != -1)
                {
                    int index = value.indexOf('-', 1);
                    reVal = value.substring(0, index);
                    imVal = value.substring(index, value.indexOf('i'));
                    if (imVal.equals("+"))
                        imVal = "1";
                    else if (imVal.equals("-"))
                        imVal = "-1";
                } else
                {
                    int index = value.indexOf('+', 1);
                    reVal = value.substring(0, index);
                    imVal = value.substring(index, value.indexOf('i'));
                    if (imVal.equals("+"))
                        imVal = "1";
                    else if (imVal.equals("-"))
                        imVal = "-1";
                }
                set(Double.parseDouble(reVal), Double.parseDouble(imVal));
            } else if (real)
            {
                set(Double.parseDouble(value), 0);
            } else
            {
                String result = value.substring(0, value.indexOf('i'));
                if (result.equals("-"))
                    result = "-1";
                else if (result.equals("+") || result.equals(""))
                    result = "1";
                set(0, Double.parseDouble(result));
            }
        } catch(Exception e) {
            throw new NumberFormatException();
        }
    }

    @Override
    public ComplexNumber copy()
    {
        ComplexNumber result = new ComplexNumberImpl();
        result.set(re, im);
        return result;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException
    {
        ComplexNumber result = new ComplexNumberImpl();
        result.set(re, im);
        return result;
    }

    @Override
    public int compareTo(ComplexNumber other)
    {
        Double abs = Math.pow(re, 2) + Math.pow(im, 2);
        Double otherAbs = Math.pow(other.getRe(), 2) + Math.pow(other.getIm(), 2);
        return abs.compareTo(otherAbs);
    }

    @Override
    public void sort(ComplexNumber[] array)
    {
        Arrays.sort(array, new Comparator<ComplexNumber>() {
            public int compare(ComplexNumber c1, ComplexNumber c2) {
                return c1.compareTo(c2);
            }
        });
    }

    @Override
    public ComplexNumber negate()
    {
        set(-re, -im);
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2)
    {
        set(re + arg2.getRe(), im + arg2.getIm());
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2)
    {
        set(re * arg2.getRe() - im * arg2.getIm(), re * arg2.getIm() + im * arg2.getRe());
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || !(o instanceof ComplexNumber)) return false;

        ComplexNumber that = (ComplexNumber) o;

        if (re != null ? !re.equals(that.getRe()) : !Double.isNaN(that.getRe())) return false;
        return !(im != null ? !im.equals(that.getIm()) : !Double.isNaN(that.getIm()));

    }

    @Override
    public int hashCode()
    {
        int result = re != null ? re.hashCode() : 0;
        result = 31 * result + (im != null ? im.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        if(im == 0)
            return re.toString();
        else if(re == 0)
            return im + "i";
        else if(im > 0)
            return re + "+" + im + "i";
        else
            return re + (im + "i");
    }
}
