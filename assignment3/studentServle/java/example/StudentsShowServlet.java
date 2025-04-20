package example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practise.jdbc.Student;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class showStudentServlet
 * @param <HttpServletResponse>
 */
@WebServlet("/showStudent")
public class StudentsShowServlet<HttpServletResponse> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param <HttpServletRequest>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected <HttpServletRequest> void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Object obj = request.getAttribute("loadedStudent");
		Student st = (Student)obj;
		String name = st.getName();
		String city = st.getCity();
		out.println("<h2>Showing Student Details: </h2>");
		out.println("<h2>Name: " + name + "</h2>");
		out.println("<h2>City: "+ city + "</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
