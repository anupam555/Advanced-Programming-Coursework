package com.company;
public class calculator <T> {
    private int a;
    private int b;
    private String s1;
    private String s2;
    public calculator(T value1, T value2) {
        try {
            if (value1 instanceof Integer && value2 instanceof Integer) {
                a = (Integer) value1;
                b = (Integer) value2;
            } else if (value1 instanceof String && value2 instanceof String) {
                s1 = (String) value1;
                s2 = (String) value2;
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Illegal datatypes for arguments.");
        }
    }
    public String concatenate()
    {
        return s1+s2;
    }

    public int divide()
    {
      return (int)(a/b);
    }
}
