public class LectureVideo implements LectureMaterial {
    private String topic;
    private String filename;
    private String date;
    private String uploadedBy;

    public LectureVideo(String topic, String filename, String date, Teacher t) {
        this.topic = topic;
        this.filename = filename;
        this.date = date;
        this.uploadedBy = t.getName();
    }

    @Override
    public void view() {
        System.out.println("Title of Video " + this.topic);
        System.out.println("Video file: " + this.filename);
        System.out.println("Date of upload: " + this.date);
        System.out.println("Uploaded by: " + this.uploadedBy);
    }
}