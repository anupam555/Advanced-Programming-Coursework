package com.company;
import java.util.*;
public class slot {
    private int slots;
    int hospital_id;
    long pid;
    int days;
    int quantity;
    String vaccinedose;
    String hname;

    slot(int s, int hos_id, int daynum, int quan, String dose, String name)
    {
        this.slots=s;
        this.hospital_id=hos_id;
        this.days=daynum;
        this.quantity=quan;
        this.vaccinedose=dose;
        this.hname=name;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public int getDays()
    {
        return days;
    }
    public void setDays(int d)
    {   this.days=d;
    }
    public void setPersonId(long id){
        this.pid=id;
    }
    public long getPersonId(){
        return pid;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
    public int getHospital_id()
    {
        return hospital_id;
    }
    public void setHospital_id(int i)
    {
        this.hospital_id=i;
    }
    public void displaySlot()
    {
        System.out.println("Slot added by Hospital "+hospital_id+" for Day: "+days+", Available Quantity: "+quantity+" of Vaccine "+vaccinedose);
    }
    public void availableSlots()
    {   System.out.println(" Day "+days+" Vaccine: "+vaccinedose+" Available Qty "+quantity);
    }
}
