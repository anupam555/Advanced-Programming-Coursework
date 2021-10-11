package com.company;
import java.util.*;
public class hospital {
    String hospital_name;
    int pcode;
    int unique_hID;

    hospital(String hosp_name,int pin_code)
    {
        this.hospital_name=hosp_name;
        this.pcode =pin_code;
        this.unique_hID=(int)(Math.random()*(999999-100000+1)+100000);
    }

    public void display()
    {
        System.out.print("Hospital Name: "+hospital_name+", ");
        System.out.print(" Pincode: "+ pcode +", ");
        System.out.print(" Unique ID: "+unique_hID);
    }
}
