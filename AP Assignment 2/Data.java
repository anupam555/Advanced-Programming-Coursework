import java.util.ArrayList;
public class Data {
    private ArrayList<LectureMaterial> material;
    private ArrayList<Assessment> assessments;
    private ArrayList<Comment> comments;

    public Data() {
        material = new ArrayList<LectureMaterial>();
        assessments = new ArrayList<Assessment>();
        comments = new ArrayList<Comment>();
    }

    // teacher t passed as parameter to ensure that t is a teacher
    public void addMaterial(LectureMaterial l, Teacher t) {
        if (t != null)
            material.add(l);
    }

    public void viewMaterial() {
        for (LectureMaterial lm : material) {
            lm.view();
        }
    }
    
    public void addAssessment(Assessment a, Teacher t) {
        if (t != null)
            assessments.add(a);
    }

    public boolean viewAssessments() {
        int len = assessments.size();
        for (int i = 0; i < len; i++) {
            System.out.println("ID: " + i + " " + assessments.get(i).view());
            System.out.println("----------------");
        }
        if (len == 0)
            return false;
        return true;
    }

    public boolean viewUngradedSubmissions(Teacher t, int index) {
        return assessments.get(index).viewSubmissions(t);
    }

    public boolean viewOpenAssessments(Teacher t) {
        ArrayList<Assessment> oa = openAssessments();
        for (int i = 0; i < oa.size(); i++) {
            System.out.println("ID: " + i + " " + oa.get(i).view());
        }
        if (oa.size() == 0)
            return false;
        return true;
    }

    public void closeAssessments(Teacher t, int index) {
        ArrayList<Assessment> oa = openAssessments();
        oa.get(index).close(t);
    }

    public Submission getSubmission(Teacher t, int aid, int sid) {
        return assessments.get(aid).grade(t, sid);
    }

    public void addComment(String comment, String name, String date) {
        Comment c = new Comment(name, comment, date);
        comments.add(c);
    }

    public void viewComments() {
        for (Comment c : comments) {
            c.view();
            System.out.println();
        }
    }

    public boolean viewPendingAssessments(Student s) {
        ArrayList<Assessment> arr = pendingAssessments(s);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("ID: " + i + " " + arr.get(i).view());
        }
        if (arr.size() == 0)
            return false;
        return true;
    }

    public boolean pendingAssessmentType(Student s, int id) {
        ArrayList<Assessment> arr = pendingAssessments(s);
        return arr.get(id).quizType();
    }

    public void submitAssessment(Student s, int id, String solution) {
        ArrayList<Assessment> arr = pendingAssessments(s);
        arr.get(id).submit(s, solution);
    }

    private ArrayList<Assessment> pendingAssessments(Student s) {
        ArrayList<Assessment> arr = new ArrayList<Assessment>();
        for (Assessment assess : assessments) {
            // neither marked as done nor closed
            if ((assess.markedAsDone(s) == false) && (assess.isClosed() == false)) {
                arr.add(assess);
            }
        }
        return arr;
    }

    private ArrayList<Assessment> openAssessments() {
        ArrayList<Assessment> openass = new ArrayList<Assessment>();
        int len = assessments.size();
        for (int i = 0; i < len; i++) {
            if (assessments.get(i).isClosed() == false) {
                openass.add(assessments.get(i));
            }
        }
        return openass;
    }

}
