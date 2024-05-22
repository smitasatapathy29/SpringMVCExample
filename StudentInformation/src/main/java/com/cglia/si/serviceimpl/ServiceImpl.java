package com.cglia.si.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cglia.si.DAO.StudentDAO;
import com.cglia.si.DAOimpl.DAOImpl;
import com.cglia.si.model.Student;
import com.cglia.si.service.StudentService;
@Service
public class ServiceImpl implements StudentService {
	
	@Override
	public Integer save(Student student) {	
	StudentDAO dao = new DAOImpl();
	   Integer id=dao.save(student);
	   return id;
	}

	@Override
	public Boolean delete(int id) {
		StudentDAO dao = new DAOImpl();
		return dao.delete(id);
		
	}

	@Override
	public List<Student> show() {
		StudentDAO dao = new DAOImpl();
		List<Student> student = dao.show();
		return student;
			}

	@Override
	public Integer update(Student std) {
		StudentDAO dao = new DAOImpl();
		return dao.update(std);
	}

	@Override
	public Student showStdById(Integer id) {
		StudentDAO dao = new DAOImpl();
		Student std= dao.showStdById(id);
		return std;
	}

		}



