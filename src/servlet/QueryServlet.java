package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

@WebServlet("/Query")
public class QueryServlet extends HttpServlet  {
	private StudentService ss=new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������������
		req.setCharacterEncoding("UTF-8");
		String stuId = req.getParameter("id");
		System.out.println(stuId);
		List<Student> list=ss.getAll();
		// ����õ��������õ���������
		req.setAttribute("list", list);
		// ҳ����ת
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
