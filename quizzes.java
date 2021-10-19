public class quizzes {
    String quizproblem;
    int quizmarks;
    quizzes(String s)
    {
        this.quizproblem=s;
        this.quizmarks=1;
    }
    public void printquiz()
    {
        System.out.print("Question "+this.quizproblem);
    }
}
