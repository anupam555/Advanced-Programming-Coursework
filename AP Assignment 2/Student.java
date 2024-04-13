import java.util.*;
public class Student {
	private static int count = 0; //number of students
	private String name;
	private int id;  //unique identifier
	private Data data;
	ArrayList<Submission> mysubmissions;

	public Student(String name, Data data){
		this.data = data;
		this.name = name;
		this.id = count;
		count++;
		mysubmissions = new ArrayList<Submission>();
	}
	public String getName(){
		return this.name;
	}
	public int getId(){
		return this.id;
	}
	public void submit(Submission sbm){
		mysubmissions.add(sbm);
	}
	public boolean viewPendingAssessments(){
		return data.viewPendingAssessments(this);
	}
	public void submitAssessment(int id,String solution){
		data.submitAssessment(this,id,solution);
	}
	public void viewGrades(){
		ArrayList<Submission> gsubs = gradedSubmissions();
		ArrayList<Submission> ungsubs = ungradedSubmissions();
		System.out.println("Graded Submissions:");
		System.out.println();
		for(Submission sbm: gsubs){
			sbm.gradeinfo();
		}
		System.out.println("Ungraded Submissions:");
		System.out.println();
		for(Submission sbm: ungsubs){
			sbm.gradeinfo();
		}
	}
	private ArrayList<Submission> gradedSubmissions(){
		ArrayList<Submission> subs = new ArrayList<Submission>();
		for(Submission sbm: mysubmissions){
			if(sbm.isGraded() == true){
				subs.add(sbm);
			}
		}
		return subs;
	}
	private ArrayList<Submission> ungradedSubmissions(){
		ArrayList<Submission> subs = new ArrayList<Submission>();
		for(Submission sbm: mysubmissions){
			if(sbm.isGraded() == false){
				subs.add(sbm);
			}
		}
		return subs;
	}
	
}