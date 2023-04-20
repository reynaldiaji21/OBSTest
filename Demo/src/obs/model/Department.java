package obs.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private int id;
	private String name;
	private List<Student> students= new ArrayList<Student>();
	private double pass;
	public Department() {
		// TODO Auto-generated constructor stub
	}

	

	public Department(int id, String name, double pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public double getPass() {
		return pass;
	}

	public void setPass(double pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", students=" + students + "]";
	}


}
