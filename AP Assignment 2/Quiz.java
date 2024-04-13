import java.util.*;
public class Quiz implements Assessment {
	private boolean close;
	private String question;
	private ArrayList<Submission> submissions;
	private int maxmarks;
	
	public Quiz(String question){
		this.question = question;
		close = false;
		submissions = new ArrayList<Submission>();
		this.maxmarks = 1;
	}
	@Override
	public String view(){
		return this.toString();
	}
	@Override
	public Submission grade(Teacher t, int sid){
		// returns the submission that we have to grade
		ArrayList<Submission> subs = ungradedSubmissions();
		return subs.get(sid);
	}
	@Override
	public void close(Teacher t){
		this.close = true;
	}
	@Override
	public void submit(Student s, String solution){
		Submission stemp = new Submission(s,this,solution);
		s.submit(stemp);
		submissions.add(stemp);
	}
	@Override
	public boolean isClosed(){
		return this.close;
	}
	@Override
	public boolean viewSubmissions(Teacher t){
		//to view all the ungraded submissions
		ArrayList<Submission> subs = ungradedSubmissions();
		int len = subs.size();
		for(int i = 0; i < len; i++){
			System.out.println(i+". "+subs.get(i).getName());
		}
		if(len == 0) return false;
		return true;
	}

	@Override
	public int getMaxMarks(){
		return this.maxmarks;
	}
	@Override
	public boolean markedAsDone(Student s){
		for(Submission sbm: submissions){
			if(sbm.getId() == s.getId()){
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean quizType(){
		return true;
	}


	private ArrayList<Submission> ungradedSubmissions(){
		ArrayList<Submission> ungrads = new ArrayList<Submission>();
		int len = submissions.size();
		for(int i = 0; i < len; i++){
			if(submissions.get(i).isGraded() == false){
				ungrads.add(submissions.get(i));
			}
		}
		return ungrads;
	}
	
	@Override
	public String toString(){
		return "Question: "+this.question;
	}
}