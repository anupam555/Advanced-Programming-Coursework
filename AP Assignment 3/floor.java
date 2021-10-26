public class floor {
    private String fname;
    private String name;
    private int pos;
    floor()
    {
        fname="Empty";
    }

    floor(String name,int pos)
    {   fname="Empty";
        this.name=name;
        this.pos=pos;
    }
    public String getFloorName()
    {
        return fname;
    }
    public void setFloorName(String name)
    {
        this.fname=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.pos = position;
    }
    public int getPosition() {
        return pos;
    }
    public void display()
    {
        System.out.println("Player position Floor-"+pos);
        System.out.println(name+" has reached an "+fname+" Floor");
    }
}
