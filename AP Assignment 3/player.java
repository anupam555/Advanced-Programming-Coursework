public class player {
    private String name;
    private int points;
    player(String pname){
        name=pname;
        points=1;
    }

    public String getName()
    {
        return name;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void display()
    {
        System.out.println("Total points "+points);
    }
}
