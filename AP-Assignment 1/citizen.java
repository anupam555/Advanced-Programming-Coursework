public class citizen 
{    
    String name;
    int age;
    long unique_ID;
    int status;
    int dosecount;
    String vaccine;
    int dayofvaccine;
    int vaccineGap;
    int totalDoses;
    
    //Constructor
    citizen(String name, int age, long uid)
    {
        this.name=name;
        this.age=age;
        this.unique_ID= uid;
        this.dosecount=0;
        this.status=1;
        this.vaccineGap=0;
    }
    
    public int getDayofvaccine()
    {    return dayofvaccine;
    }

    public void setDayofvaccine(int dayofvaccine) {
        this.dayofvaccine = dayofvaccine;
    }

    public void setVaccine(String vaccine)
    {
        this.vaccine=vaccine;
    }

    public String getVaccineName()
    {   return vaccine;
    }

    public int getDosecount()
    {   return dosecount;
    }

    public void setDoseCount(int x)
    {   this.dosecount = x;
    }

    public int getStatus()
    {   return status;
    }

    public void setStatus(int vaccine_status)
    {   this.status=vaccine_status;
    }

    public String getName()
    {   return name;
    }

    public long getUnique_ID()
    {
        return unique_ID;
    }
    
    public void display()
    {   System.out.println("Citizen name:"+name+", " + "Age:"+age+ ", "+ "Unique ID:"+unique_ID);
        System.out.println();
        if(age<18)
        {   System.out.println("Only above 18 are allowed");
        }
    }
}