public class Submission {
	private Student student;
	private String solution;
	private Assessment assessment;
	private boolean graded;
	private int marks;
	private String gradedBy;

	public Submission(Student s, Assessment a, String solution){
		this.student = s;
		this.assessment = a;
		this.solution = solution;
		graded = false;
		marks = 1;  //default ig
		gradedBy = "";
	}
	public void grading(Teacher t, int marks){
		this.graded = true;
		gradedBy = t.getName();
		this.marks = marks;
	}
	public boolean isGraded(){
		return this.graded;
	}
	public String getName(){
		return this.student.getName();
	}
	public int getId(){
		return this.student.getId();
	}
	public int getMaxMarks(){
		return assessment.getMaxMarks();
	}
	public String getSolution(){
		return this.solution;
	}
	public void gradeinfo(){
		if(graded == false){
			System.out.println("Submission: "+this.solution);
			System.out.println();
		} else {
			System.out.println("Submission: "+this.solution);
			System.out.println("Marks scored: " + this.marks);
			System.out.println("Graded by: "+this.gradedBy);
			System.out.println();
		}
	}
}