public interface Assessment {
	public String view();
	public Submission grade(Teacher t,int sid);
	public boolean isClosed();
	public void close(Teacher t);
	public void submit(Student s, String solution);
	public boolean viewSubmissions(Teacher t);
	public boolean markedAsDone(Student s);
	public int getMaxMarks();
	public boolean quizType();
}