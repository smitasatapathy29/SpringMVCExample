package com.cglia.si.service;

import java.util.List;

import com.cglia.si.model.Student;
public interface StudentService {

	public Integer save(Student student);
	public Boolean delete(int id);
	public List<Student> show();
	public Integer update(Student std);
	public Student showStdById(Integer id);

}
