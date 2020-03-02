package service;

import java.util.List;

import entity.Student;

public interface StudentService {
	Student findById(String id);
	List<Student> getAll();
}
