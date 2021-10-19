import java.sql.Array;
import java.util.*;
public class backpack
{   static ArrayList<instructor> instructors= new ArrayList<>();
    static ArrayList<student> students= new ArrayList<>();
    static ArrayList<lectureslide> ls= new ArrayList<>();
    static ArrayList<lecturevideos> lv = new ArrayList<>();
    static ArrayList<assignments> as = new ArrayList<>();
    static ArrayList<quizzes> quiz = new ArrayList<>();
    static ArrayList<student> asub= new ArrayList<>();
    static ArrayList<student> qsub=new ArrayList<>();
    static ArrayList<String> comments=new ArrayList<>();
    public static void main(String[] args)
    {   Scanner scn= new Scanner(System.in);

        instructor i0= new instructor("I0");
        instructor i1= new instructor("i1");

        instructors.add(i0);
        instructors.add(i1);

        student s0= new student("S0");
        student s1= new student("S1");

        students.add(s0);
        students.add(s1);

        while(true) {
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as an Instructor");
            System.out.println("2. Enter as a Student");
            System.out.println("3. Exit");
            int n = scn.nextInt();
            if(n==1)
            {
                System.out.println("Instructors:");
                System.out.println("0 - I0");
                System.out.println("1 - I1");

                int id=scn.nextInt();

                if(id==0)
                {
                    System.out.println("Welcome IO");
                }

                else if(id==1)
                {
                    System.out.println("Welcome I1");
                }

                while(true)
                {
                    System.out.println("1.Add Class Material");
                    System.out.println("2.Add Assessments");
                    System.out.println("3.View lecture materials ");
                    System.out.println("4.View Assessments ");
                    System.out.println("5.Grade Assessments");
                    System.out.println("6.Close Assessments");
                    System.out.println("7.View Comments");
                    System.out.println("8.Add Comments");
                    System.out.println("9.Exit");
                    int c=scn.nextInt();
                    if(c==1)
                    {
                        System.out.println("1. Add lecture Slide");
                        System.out.println("2. Add lecture video");
                        int choice = scn.nextInt();
                        if(choice==1)
                        {
                            String topic;
                            int ns;
                            String str;
                            ArrayList<String> content= new ArrayList<>();
                            System.out.println("Enter the topic of slides:");
                            topic=scn.nextLine();
                            if(topic.length()==0)
                            {
                                topic=scn.nextLine();
                            }
                            System.out.println("Enter the number of slides:");
                            ns=scn.nextInt();
                            System.out.println("Enter the content of the slides:");
                            for(int i=0; i<ns; i++)
                            {
                                System.out.println("Content of slide"+i+": ");
                                str=scn.nextLine();
                                if(str.length()==0)
                                {   str=scn.nextLine();
                                }
                                content.add(str);
                            }
                            lectureslide l= new lectureslide(topic,ns,content,instructors.get(id).getName());
                            ls.add(l);
                        }
                        else if(choice==2)
                        {
                            String vtopic;
                            String filename;
                            System.out.println("Enter the topic video");
                            vtopic=scn.nextLine();
                            if(vtopic.length()==0)
                            {
                                vtopic=scn.nextLine();
                            }
                            System.out.println("Enter the filename of the video");
                            filename=scn.nextLine();
                            if(filename.length()==0)
                            {
                                filename=scn.nextLine();
                            }
                            int len=filename.length();
                            if(filename.endsWith(".mp4"))
                            {
                                lecturevideos lectv = new lecturevideos(vtopic,filename,instructors.get(id).getName());
                                lv.add(lectv);
                            }
                            else
                            {
                                System.out.println("Invalid video file.");
                            }
                        }
                    }
                    else if(c==2)
                    {   String statement;
                        int mmarks;
                        System.out.println("1. Add Assignment");
                        System.out.println("2. Add Quiz");
                        int option=scn.nextInt();
                        if(option==1)
                        {
                            System.out.println("Enter the problem statement:");
                            statement=scn.next();
                            if(statement.length()==0)
                            {
                                statement=scn.next();
                            }
                            System.out.println("Enter the maximum marks");
                            mmarks=scn.nextInt();
                            assignments a= new assignments(statement, mmarks);
                            as.add(a);
                        }
                        else if(option == 2)
                        {
                            System.out.println("Enter the quiz question:");
                            statement=scn.next();
                            quizzes q= new quizzes(statement);
                            quiz.add(q);
                        }
                    }
                    else if(c==3) {
                        int j=0;
                        for(int i=0; i<ls.size(); i++) {
                            System.out.print("ID:"+j+" ");
                            ls.get(i).displayLectureSlides();
                            j++;
                        }
                        for(int i=0; i<lv.size(); i++)
                        {
                            System.out.print("ID: "+j+" ");
                            lv.get(i).displayVideo();
                            j++;
                        }
                    }
                    else if(c==4)
                    {   int count=0;
                        for(int k = 0;  k<as.size(); k++) {
                            System.out.print(count);
                            as.get(k).printAssignments();
                            count++;
                        }
                        for(int k = 0;  k<quiz.size(); k++) {
                            System.out.print(count);
                            quiz.get(k).printquiz();
                            count++;
                        }
                    }
                    else if(c==5)
                    {   int cos; // choice of student
                        System.out.println("List of Assignments");
                        int count=0;
                        for(int i = 0; i < as.size(); i++) {
                            System.out.print(count);
                            as.get(i).printAssignments();
                            count+=1;
                        }
                        for(int k = 0;  k<quiz.size(); k++) {
                            System.out.print(count);
                            quiz.get(k).printquiz();
                            count++;
                        }
                        System.out.println("Enter the id of Assessments to view submissions:");
                        int assignid = scn.nextInt();
                        int mark;
                        if(assignid<as.size())
                        {   mark=assignid;
                            System.out.println("Choose ID from the ungraded submission");

                            System.out.println("0. S0");
                            System.out.println("1. S1");
                            cos=scn.nextInt();
                            System.out.println("SUBMISSIONS:");

                        }
                        else
                        {
                            mark=assignid-as.size();
                            System.out.println("Choose ID from the ungraded submission");
                            cos=scn.nextInt();
                            System.out.println("SUBMISSIONS:");
                        }
                    }
                    else if( c==6)
                    {
                        System.out.println("List of Open Assignments");
                        int count=0;
                        for(int i = 0; i < as.size(); i++) {
                            System.out.print(count);
                            as.get(i).printAssignments();
                            count++;
                        }
                        for(int i = 0; i < quiz.size(); i++) {
                            System.out.print(count);
                            as.get(i).printAssignments();
                            count++;
                        }
                        System.out.println("Enter the id of the assessment to close:");
                        int aid=scn.nextInt();
                        if(aid==0) {
                            as.remove(0);
                        }
                        else if(aid==1)
                        {
                            as.remove(1);
                        }
                    }
                    else if(n==7) // View comments
                    {
                        for(int i=0; i<comments.size(); i++) {
                            System.out.print(comments.get(i));
                        }
                    }
                    else if(n==8) // Add comments
                    {
                        String comment;
                        System.out.println("Enter comment");
                        comment=scn.next();
                        comments.add(comment);
                    }
                    else if(n==9)
                    {   break;
                    }
                }
            }
            else if(n==2)
            {
                System.out.println("Students:");
                System.out.println("0 - S0");
                System.out.println("1 - S1");
                int id=scn.nextInt();
                if(id==0)
                {
                    System.out.println("Welcome S0");
                }
                else if(id==1) {
                    System.out.println("Welcome S1");
                }
                else {  System.out.println("Invalid ID .");
                        }
                while(true)
                {
                    System.out.println("1.View Lecture Material");
                    System.out.println("2.View Assessments ");
                    System.out.println("3.Submit Assessments");
                    System.out.println("4.View grades ");
                    System.out.println("5.View Comments");
                    System.out.println("6.Add Comments");
                    System.out.println("7.Exit");
                    int opt=scn.nextInt();
                    if(opt==1)
                    {
                        for(int i=0; i<ls.size(); i++)
                        {
                            ls.get(i).displayLectureSlides();
                        }
                        for(int i=0; i<lv.size(); i++)
                        {
                            lv.get(i).displayVideo();
                        }
                    }
                    else if(opt==2)
                    {
                        for(int i = 0; i < as.size(); i++) {
                            as.get(i).printAssignments();
                        }

                        for(int i=0; i<quiz.size(); i++)
                        {   quiz.get(i).printquiz();
                        }
                    }
                    else if(opt==3)
                    {
                        System.out.println("Pending assignments");
                        int count=0;
                        for(int i=0; i<as.size(); i++)
                        {   System.out.print(count);
                            as.get(i).printAssignments();
                        }
                        System.out.println("Enter the ID of assessment");
                        int assignmentid = scn.nextInt();
                        int marks;
                        System.out.println("Enter the file name of the assignment");
                        String filename=scn.nextLine();
                        int length=filename.length();
                        if(filename.endsWith(".zip"))
                        {   String aprob=as.get(assignmentid).getAssignname();
                            System.out.println("Max Marks:"+as.get(assignmentid).getMarks());
                            marks=scn.nextInt();
                            student s= new student(aprob,filename,marks);
                            asub.add(s);
                        }
                    }
                    else if(opt==4)
                    {
                    }
                    else if(opt==5)
                    {
                        for(int i=0; i<comments.size(); i++) {
                            System.out.print(comments.get(i));
                        }
                    }
                    else if(opt==6)
                    {   String comment;
                        System.out.println("Enter comment");
                        comment=scn.next();
                        comments.add(comment);
                    }
                    else if(opt==7)
                    {
                        break;
                    }
                }
            }
            else
            {
                break;
            }
        }
    }
}
