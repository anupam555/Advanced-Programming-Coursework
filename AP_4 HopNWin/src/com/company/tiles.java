package com.company;
public class tiles implements Cloneable {
    private int number;
    private toys toy;
    public tiles()
    {
    }

    public tiles(int val, String s)
    {   this.number=val;
        toy=new toys(s);
    }

    public tiles clone() {
        try {
            tiles copy = (tiles) super.clone();
            return copy;
        }
        catch (CloneNotSupportedException e) {
            // this will never happen
            return null;
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getToyName() {
        return toy.getToyName();
    }

    public void setToyName(String toyName) {
        toy.setToyName(toyName);
    }

}
