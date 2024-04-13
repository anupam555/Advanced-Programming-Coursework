import java.util.*;
public class Backpack {
    private static Scanner scn = new Scanner(System.in);
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private Data data;

    private boolean validFile(String s, String q){
        if(s.length() <= q.length()){
            return false;
        }
        else if(q.equals(s.substring(s.length()-q.length(),s.length()))){
            return true;
        } 
        else{
            return false;
        }
    }
    
    public Backpack(){
        data = new Data();
        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
    }

    public void MainMenu(){
        Teacher t1 = new Teacher("I0",this.data);
        Teacher t2 = new Teacher("I1",this.data);
        teachers.add(t1);
        teachers.add(t2);
        Student s0 = new Student("S0",this.data);
        Student s1 = new Student("S1",this.data);
        Student s2 = new Student("S2",this.data);
        students.add(s0);
        students.add(s1);
        students.add(s2);

        while(true){
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as instructor");
            System.out.println("2. Enter as student");
            System.out.println("3. Exit");
            int choice = scn.nextInt();
            scn.nextLine();
            if(choice == 1){
                teachersMenu();
            } 
            else if (choice == 2){
                studentsMenu();
            }
            else {
                break;
            }
        }
    }

    private void printInstructorMenu(){
        System.out.println("1. Add class material");
        System.out.println("2. Add assessments");
        System.out.println("3. View lecture materials");
        System.out.println("4. View assessments");
        System.out.println("5. Grade assessments");
        System.out.println("6. Close assessments");
        System.out.println("7. View comments");
        System.out.println("8. Add comments");
        System.out.println("9. Logout");
    }
    private void teachersMenu(){
        System.out.println("Instructors:");
        for(int i = 0; i < teachers.size(); i++){
            System.out.println(i+" - "+teachers.get(i).getName());
        }
        System.out.print("Choose id: ");
        int tid = scn.nextInt(); //teachers id
        if(tid >= teachers.size()){
            System.out.println("Invalid id selected");
            return;
        }
        Teacher t = teachers.get(tid);
        int option;      //option choosen for operation
        while(true){
            System.out.println("Welcome "+t.getName());
            printInstructorMenu();
            option = scn.nextInt();
            scn.nextLine();   //eating trailing newline
            if(option == 1){
                //add lecture materials
                System.out.println("1. Add Lecture Slides");
                System.out.println("2. Add Lecture Videos");

                int choice = scn.nextInt();
                scn.nextLine(); //eating trailing newline

                if(choice == 1){
                    //lecture slide 
                    System.out.print("Enter topic of slides: ");
                    String topic = scn.nextLine();
                    System.out.print("Enter number of slides: ");
                    int n = scn.nextInt();
                    scn.nextLine();  //trailing new line
                    System.out.println("Enter Contents of Slides");

                    ArrayList<String> slides = new ArrayList<String>();
                    for(int i = 1; i <= n; i++){
                        System.out.print("Content of slide "+i+": ");
                        String temp = scn.nextLine();
                        slides.add(temp);
                    }
                    Date date = new Date();
                    LectureMaterial ltemp = new LectureSlide(topic,n,slides,date.toString(),t);  //polymorphism
                    data.addMaterial(ltemp,t);
                } else if(choice == 2){
                    //lecture video
                    System.out.print("Enter topic of video: ");
                    String topic = scn.nextLine();
                    System.out.print("Enter filename of video: ");
                    String filename = scn.next();
                    //check if valid filename
                    boolean ok = validFile(filename,".mp4");
                    Date date = new Date();
                    if(ok == true){
                        LectureMaterial ltemp = new LectureVideo(topic,filename,date.toString(),t);
                        data.addMaterial(ltemp,t);
                    } else {
                        System.out.println("Invalid file format,");
                        System.out.println("Please repeat the steps with valid file format to upload successfully.");
                        continue;
                    }
                } else {
                    System.out.println("Invalid option selected");
                }
            } else if(option == 2){
                //Add assessments
                System.out.println("1. Add Assignment");
                System.out.println("2. Add Quiz");
                int choice = scn.nextInt();
                scn.nextLine(); //eat trailing newline
                if(choice == 1){
                    System.out.print("Enter problem statement: ");
                    String problem = scn.nextLine();
                    System.out.print("Enter max marks: ");
                    int maxmarks = scn.nextInt();
                    scn.nextLine();  //trailing newline
                    Assessment atemp = new Assignment(problem,maxmarks);
                    data.addAssessment(atemp,t);
                } else if(choice == 2){
                    System.out.print("Enter quiz question: ");
                    String question = scn.nextLine();
                    Assessment qtemp = new Quiz(question);
                    data.addAssessment(qtemp,t);
                } else {
                    System.out.println("Invalid Choice entered.");
                }
            } else if(option == 3){
                data.viewMaterial();
            } 
            else if(option == 4){
                data.viewAssessments();
            } 
            else if(option == 5){
                System.out.println("List of Assessments");
                boolean nonempty = data.viewAssessments();
                if(nonempty == false){
                    System.out.println("No Assessments found.");
                    continue;
                }
                System.out.print("Enter ID of assessment to view submissions: ");
                int aid = scn.nextInt(); //assessment id
                scn.nextLine(); //eat trailing newline
                nonempty = data.viewUngradedSubmissions(t,aid);
                if(nonempty == false){
                    System.out.println("No Ungraded Submissions.");
                    continue;
                }
                int sid = scn.nextInt(); //submission id
                Submission sub = data.getSubmission(t,aid,sid);
                System.out.println("Submission: "+sub.getSolution());
                System.out.println("----------------------");
                System.out.println("Max Marks: "+sub.getMaxMarks());
                System.out.print("Marks Scored: ");
                int marks = scn.nextInt();
                scn.nextLine();
                sub.grading(t,marks);
            } else if(option == 6){
                boolean nonempty = data.viewOpenAssessments(t);
                if(nonempty == false){
                    System.out.println("No Open Assessments.");
                    continue;
                }
                System.out.print("Enter id of assessment to close: ");
                int idx = scn.nextInt();
                scn.nextLine();
                data.closeAssessments(t,idx);
            } else if(option == 7){
                data.viewComments();
            } else if(option == 8){
                System.out.print("Enter Comment: ");
                String cmt = scn.nextLine();
                Date d = new Date();
                data.addComment(cmt,t.getName(),d.toString());
            } else {
                break;
            }
        }
    }
    private void printStudentMenu(){
        System.out.println("1. View lecture materials");
        System.out.println("2. View assessments");
        System.out.println("3. Submit assessment");
        System.out.println("4. View grades");
        System.out.println("5. View comments");
        System.out.println("6. Add comments");
        System.out.println("7. Logout");
    }
    private void studentsMenu(){
        System.out.println("Students:");
        for(int i = 0; i < students.size(); i++){
            System.out.println(i+" - "+students.get(i).getName());
        }
        System.out.print("Choose id: ");
        int sid = scn.nextInt(); //Student id
        if(sid >= students.size()){
            System.out.println("Invalid id selected");
        }
        Student s = students.get(sid);
        int option;      //option choosen for operation
        while(true){
            System.out.println("Welcome "+s.getName());
            printStudentMenu();
            option = scn.nextInt();
            scn.nextLine();  //eat trailing newline
            if(option == 1){
                data.viewMaterial();
            } 
            else if(option == 2){
                data.viewAssessments();
            } 
            else if(option == 3){
                System.out.println("Pending Assessments:");
                boolean nonempty = s.viewPendingAssessments();
                if(nonempty == false){
                    System.out.println("No pending assessments");
                    continue;
                }
                System.out.print("Enter ID of assessment: ");
                int id = scn.nextInt();
                scn.nextLine();
                boolean quiztype = data.pendingAssessmentType(s,id);
                String soln;
                if(quiztype == true){
                    System.out.print("Enter Solution: ");
                    soln = scn.nextLine();
                } else {
                    System.out.print("Enter filename: ");
                    soln = scn.nextLine();
                    boolean ok = validFile(soln,".zip");
                    if(ok == false){
                        System.out.println("Invalid File entered");
                        continue;
                    }
                }
                s.submitAssessment(id,soln);
            } 
            else if(option == 4){
                s.viewGrades();
            } 
            else if(option == 5){
                data.viewComments();
            } 
            else if(option == 6){
                System.out.print("Enter Comment: ");
                String cmt = scn.nextLine();
                Date d = new Date();
                data.addComment(cmt,s.getName(),d.toString());
            }
            else {
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Backpack b = new Backpack();
        b.MainMenu();
        scn.close();
    }
}