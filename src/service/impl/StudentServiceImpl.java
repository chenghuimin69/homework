package service.impl;

import java.util.List;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao dao = new StudentDaoImpl();
	@Override
	public Student findById(String id) {
		Student st=dao.findById(id);
		return st;
	}
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
