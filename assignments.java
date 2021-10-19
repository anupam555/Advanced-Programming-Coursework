public class assignments {
    String assignprob;
    int mm;
    String insname;

    assignments(String problem, int marks)
    {
        this.assignprob=problem;
        this.mm=marks;
    }

    public String getAssignname()
    {
        return this.assignprob;
    }
    public void setAssignprob(String assignprob)
    {
        this.assignprob=assignprob;
    }
    public void printAssignments()
    {
        System.out.println(" Assignment problem "+this.assignprob);
        System.out.println(" Maximum Marks"+this.mm);
    }

    public int getMarks()
    {
        return this.mm;
    }
}
