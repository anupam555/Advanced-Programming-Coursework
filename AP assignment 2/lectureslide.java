import java.util.ArrayList;
public class lectureslide{

    String title;
    int n;
    ArrayList<String> slidecontent= new ArrayList<>();
    String name;
    lectureslide(String topic, int n, ArrayList<String> content, String name)
    {
        this.title=topic;
        this.n=n;
        this.slidecontent=content;
        this.name=name;
    }
    public void displayLectureSlides()
    {
        System.out.println("Title: "+this.title);

        for(int i=0; i<this.slidecontent.size(); i++) {
            System.out.println("Slide " + i + 1 + ": " + this.slidecontent.get(i));
        }

        System.out.println("Number of slides: "+this.n);

        System.out.println("Uploaded by: "+this.name);
    }
}
