package com.cglia.si.DAO;
import java.util.List;

import com.cglia.si.model.Student;


public interface StudentDAO {
		
		public Integer save(Student student);
		public Boolean delete(Integer id);
		public List<Student> show();
		public Integer update(Student student);
		public Student showStdById(Integer id);
		

}
