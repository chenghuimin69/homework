package dao;

import java.util.List;

import entity.Student;

public interface StudentDao {
	Student findById(String id);
	List<Student> getAll();
}
