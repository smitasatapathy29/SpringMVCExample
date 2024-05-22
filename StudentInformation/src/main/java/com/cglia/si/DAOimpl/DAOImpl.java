package com.cglia.si.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cglia.si.DAO.StudentDAO;
import com.cglia.si.DtabaseUtil.DatabaseUtil;
import com.cglia.si.model.Student;
@Repository
public class DAOImpl implements StudentDAO {

	public Integer save(Student student) {
		final String query = "INSERT INTO Student (name, email, gender, fathername, mothername, mobile, address) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

		int out=0;
		try (
				Connection con = DatabaseUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				) {
			ps.setString(1, student.getName()); // Set name
			ps.setString(2, student.getEmail()); // Set email
			ps.setString(3, student.getGender()); // Set gender
			//	ps.setString(4, student.getDob()); // Set date of birth
			ps.setString(4, student.getFatherName()); // Set father's name
			ps.setString(5, student.getMotherName()); // Set mother's name
			ps.setLong(6, student.getMobile()); // Set mobile number
			ps.setString(7, student.getAddress()); // Set address
			out = ps.executeUpdate();
			if (out != 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						Integer id = rs.getInt(1);
						System.out.println("Student saved with id=" + id);
						return id;
					}
				}
			} else {
				System.out.println("Student save failed");
				return out;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	public Boolean delete( Integer id) {
		try {
			Connection con = DatabaseUtil.getConnection();
			String query = "DELETE FROM Student WHERE id = ?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setInt(1, id); 
			return stm.executeUpdate() > 0; 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;


	}
	public List<Student> show(){
		List<Student>stdList = new ArrayList<Student>();
		try {
			Connection con = DatabaseUtil.getConnection();
			String query="SELECT * FROM Student";
			PreparedStatement stm = con.prepareStatement(query);
			ResultSet result = stm.executeQuery();
			while(result.next()) {
				Student std =new Student();
				std.setId(result.getInt("id"));
				std.setName(result.getString("name"));
				std.setEmail(result.getString("email"));
				std.setGender(result.getString("gender"));
				std.setFatherName(result.getString("fathername"));
				std.setMotherName(result.getString("mothername"));
				std.setMobile(result.getLong("mobile"));
				std.setAddress(result.getString("address"));
				stdList.add(std);
			}
		}
		catch(Exception e) {

		}
		return stdList;
	}

	public Integer update(Student student) {
		final String query="UPDATE Student SET name= ?,  email = ?, gender = ?, fathername = ? , mothername = ?, mobile =? , address = ? WHERE id = ?";
		int count=0;
		try(Connection con=DatabaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getEmail());
			stmt.setString(3, student.getGender());
			stmt.setString(4, student.getFatherName());
			stmt.setString(5, student.getMotherName());	
			stmt.setLong(6, student.getMobile());
			stmt.setString(7, student.getAddress());
			stmt.setInt(8,student.getId());
			count=stmt.executeUpdate();
			if(count!=0) {
				System.out.println("Student with ID:"+student.getId()+" is updated");
			}else {
				System.out.println("update failed.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return count;
	}

	@Override
	public Student showStdById(Integer id) {
		Student std = null;
		String query = "SELECT * FROM Student WHERE id = ?";
		try(Connection con=DatabaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				std = new Student();
				std.setId(result.getInt("id"));
				std.setName(result.getString("name"));
				std.setEmail(result.getString("email"));
				std.setGender(result.getString("gender"));
				std.setFatherName(result.getString("fathername"));
				std.setMotherName(result.getString("mothername"));
				std.setMobile(result.getLong("mobile"));
				std.setAddress(result.getString("address"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return std;	

	}					
}





