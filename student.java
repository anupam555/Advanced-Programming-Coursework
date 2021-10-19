import java.util.*;
public class student{
    private String sname;
    private int assignmentno;
    String assignfile;
    int marks;
    String assigneval;

    ArrayList<String> comment= new ArrayList<>();
    ArrayList<assignments> asub= new ArrayList<>();
    ArrayList<quizzes> qcheck=new ArrayList<>();

    student()
    {
    }

    student(String name)
    {
        this.sname=name;
    }

    student(String aname, String filename, int marks)
    {
        this.sname=aname;
        this.assignfile=filename;
        this.marks=marks;
    }

    public String getName()
    {
        return this.sname;
    }

    public void submissionAssign(int ano)
    {
    }

    public void setMarks(int mark)
    {
        this.marks=mark;
    }

    public void addComments(String st)
    {
        comment.add(st);
    }
    public void viewComments() {
        for (int i = 0; i < comment.size(); i++) {
            System.out.println(comment);
        }
    }
    public int getMarks()
    {   return this.marks;
    }
}
