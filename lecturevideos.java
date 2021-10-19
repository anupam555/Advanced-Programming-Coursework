import java.util.ArrayList;
public class lecturevideos {
    String uploader;
    String videotitle;
    String filename;
    lecturevideos(String topic, String fname, String person)
    {
        this.videotitle=topic;
        this.filename=fname;
        this.uploader=person;
    }
    public void displayVideo()
    {
        System.out.println("Title of video: "+this.videotitle);

        System.out.println("Video file: "+this.filename);

        System.out.println("Uploaded by: "+this.uploader);
    }
}
