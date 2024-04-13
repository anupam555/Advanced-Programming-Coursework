public class Teacher {
	private static int count = 0; //number of teachers
	private String name;
	private int id;  //unique identifier
	private Data data; //data includes lecture materials, assessments and comments
	
	public Teacher(String name, Data data){
		this.name = name;
		this.data = data;
		this.id = count;
		count++;
	}
	public String getName(){
		return this.name;
	}
}
