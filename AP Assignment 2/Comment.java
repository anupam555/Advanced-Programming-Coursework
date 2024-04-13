public class Comment {
    private String comment;
    private String date;
    private String name;

    public Comment(String name, String cmt, String date) {
        this.comment = cmt;
        this.name = name;
        this.date = date;
    }

    public void view() {
        System.out.println(comment + " - " + this.name);
        System.out.println(date);
    }

}