import java.util.*;
public class instructor {
    private String name;
    private String title;
    private int nslides;
    private String content;
    private String v_name;
    private String fname;
    private String assigns="";
    private int amarks=0;
    private String quizstate;
    private int qmarks=1;

    ArrayList<String> slidecontent= new ArrayList<>();

    ArrayList<String> comments= new ArrayList<>();

    instructor() {
    }

    instructor(String name) {
        this.name=name;
    }

//    public void viewLectureMaterial()
//    {
//            displayLectureSlides();
//            displayVideo();
//    }

//    public void useDisplayAssessments(users user)
//    {
//        user.displayAssesments();
//    }

    public void addComments(String s)
    {
        comments.add(s);
    }

    public void viewComments() {
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(comments);
        }
    }

    public String getName()
    {
        return this.name;
    }


    public void addLecturevideo(String videotopic, String file)
    {
        this.v_name=videotopic;
        this.fname=file;
    }
    public void addAssignment(String qstate, int mm)
    {
        this.assigns=qstate;
        this.amarks=mm;
    }

    public void setAssignmentName(String s)
    {
        this.assigns=s;
    }

    public int getassignmarks()
    {
        return this.amarks;
    }

    public void addQuiz(String quizStatement)
    {
        this.quizstate=quizStatement;
    }
}

