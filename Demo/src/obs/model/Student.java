package obs.model;

public class Student {
	private String studentId;
	private String studentName;
	private int mark;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String studentId, String studentName,  int mark) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.mark = mark;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	

}
