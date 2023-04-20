package obs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;


import obs.model.Department;
import obs.model.Student;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final int PASS = 40;
	public static final double PERCENT = 100.0;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Department> list = new ArrayList<Department>();
		list = getListDepartments();

		ObjectMapper mapper = new ObjectMapper();
		String newJsonData = mapper.writeValueAsString(list);

		String name = req.getParameter("uname");
		String pass = req.getParameter("password");
		HttpSession ses = req.getSession();
		ses.setAttribute("list", newJsonData);
		if (name.equals("admin") && pass.equals("admin")) {
			ses.setAttribute("username", name);
			res.sendRedirect("page.jsp");

		} else {
			ses.setAttribute("error", "Invalid Username or Password");
			res.sendRedirect("login.jsp");
		}
	}
  	
	public List<Department> getListDepartments() {
		List<Department> departments = new ArrayList<Department>();
		List<Department> listDepartments = new ArrayList<Department>();
		Department dep1 = new Department(1, "Dep1", 0);
		Student s1 = new Student("S1", "Student1", 35);
		dep1.getStudents().add(s1);
		Student s2 = new Student("S2", "Student2", 70);
		dep1.getStudents().add(s2);
		Student s3 = new Student("S3", "Student3", 60);
		dep1.getStudents().add(s3);
		Student s4 = new Student("S4", "Student4", 90);
		dep1.getStudents().add(s4);

		Department dep2 = new Department(2, "Dep2", 0);
		Student s5 = new Student("S5", "Student5", 30);
		dep2.getStudents().add(s5);

		Department dep3 = new Department(3, "Dep3", 0);
		Student s6 = new Student("S6", "Student6", 32);
		dep3.getStudents().add(s6);
		Student s7 = new Student("S7", "Student7", 70);
		dep3.getStudents().add(s7);
		Student s8 = new Student("S8", "Student8", 20);
		dep3.getStudents().add(s8);

		departments.add(dep1);
		departments.add(dep2);
		departments.add(dep3);

		listDepartments = newListDepartments(departments);
		return listDepartments;
	}

	public List<Department> newListDepartments(List<Department> lstDep) {
		/*
		 *  set new Department with Pass value 
		 *  */
		List<Department> newListDep = new ArrayList<Department>();
		for (Department dep : lstDep) {
			Department newDep = new Department();
			double value = calculatePass(dep);
			newDep.setId(dep.getId());
			newDep.setName(dep.getName());
			newDep.setStudents(dep.getStudents());
			newDep.setPass(value);
			newListDep.add(newDep);
		}
		return newListDep;
	}
	
	public double calculatePass(Department dep) {
		/*
		 *  for calculate Pass with condition pass >=40 
		 *  */
		int countPass = 0;
		int countAll = 0;
		double resultPass,resultAll,result;
		for (Student st : dep.getStudents()) {
			if (st.getMark() >= PASS) {
				countPass++;
			}
			countAll++;

		}
		resultPass = countPass;
		resultAll = countAll;
		result = resultPass / resultAll * PERCENT;
	    
		return result;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  doGet(req, res);

	}

}
