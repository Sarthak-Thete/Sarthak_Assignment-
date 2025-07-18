package example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practise.jdbc.JDBCdao;
import practise.jdbc.Student;
import practise.jdbc.StudentDao;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addStudent")
public class StudentServlet<HttpServletResponse, HttpServletRequest> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		((Object) response).setContentType("text/html");
		PrintWriter out = response.getWriter();
		int RollNo = Integer.parseInt(request.getParameter("rollno"));
		String Name = request.getParameter("name");
		String City = request.getParameter("city");
		
		Student currentStudent = new Student(RollNo,Name,City);
		JDBCdao<Student, Integer> dao = new StudentDao();
		dao.add(currentStudent);
		out.println("<h2>Student added successfully.</h2>");
	}


	protected <HttpServletRequest> void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
