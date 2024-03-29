package com.company;
import java.util.*;
public class citizen {
    private String name;
    private int age;
    private long unique_ID;
    private int status;
    private int dosecount;
    private String vaccine;
    private int dayofvaccine;
    int vaccinegap;
    int totaldoses;
    citizen(String str, int age, long uid)
    {
        this.name=str;
        this.age=age;
        this.unique_ID= uid;
        this.dosecount=0;
        this.status=1;
        this.vaccinegap=0;
    }

    public int getDayofvaccine() {
        return dayofvaccine;
    }

    public void setDayofvaccine(int dayofvaccine) {
        this.dayofvaccine = dayofvaccine;
    }

    public void setVaccine(String vaccine)
    {
        this.vaccine=vaccine;
    }
    public String getVaccineName()
    {
        return vaccine;
    }

    public int getDosecount()
    {   return dosecount;
    }

    public int setDoseCount(int x)
    {   return dosecount=x;
    }

    public int getStatus()
    {   return status;
    }

    public void setStatus(int vaccine_status)
    {   this.status=vaccine_status;
    }
    public String getName()
    {
        return name;
    }
    public long getuniqueid()
    {
        return unique_ID;
    }
    public void display()
    {   System.out.println("Citizen name:"+name);
        System.out.println("Age:"+age);
        System.out.println("Unique ID:"+unique_ID);
        if(age<18)
        {   System.out.println("Only above 18 are allowed");
        }
    }
}
