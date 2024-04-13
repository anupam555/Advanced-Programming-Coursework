import java.util.ArrayList;

public class LectureSlide implements LectureMaterial{
	private String topic;  //topic name of slide
	private int num;      //number of slides
	private ArrayList<String> slides; 
	private String date;
	private String uploadedBy;
	
	public LectureSlide(String topic, int num, ArrayList<String> slides, String date, Teacher t){
		this.topic = topic;
		this.num = num;
		this.slides = slides;
		this.date = date;
		this.uploadedBy = t.getName();
	}
    
	@Override
	public void view(){
		System.out.println("Title: "+this.topic);
		int len = slides.size();
		System.out.println("Number of slides: "+len);
		for(int i = 1; i <= len; i++){
			System.out.println("Slide: "+i+" "+this.slides.get(i-1));
		}
		System.out.println("Date of upload: "+this.date);
		System.out.println("Uploaded by: "+this.uploadedBy);
		System.out.println();
	}
}