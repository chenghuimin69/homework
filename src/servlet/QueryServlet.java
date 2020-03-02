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
		// 处理中文乱码
		req.setCharacterEncoding("UTF-8");
		String stuId = req.getParameter("id");
		System.out.println(stuId);
		List<Student> list=ss.getAll();
		// 将获得的数据设置到作用域中
		req.setAttribute("list", list);
		// 页面跳转
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
