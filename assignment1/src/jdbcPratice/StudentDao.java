package jdbcPratice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements StudDao<Student,Integer> {

	@Override
	public Collection<Student> getAll() {
		Collection<Student> student=new ArrayList<>();
		try {
			Connection stConnection=studUtils.buildConnection();
			Statement stmt = stConnection.createStatement();
			ResultSet rs= stmt.executeQuery("Select * from stud");
			while(rs.next()) {
				int rollNo=rs.getInt(1);
				String name=rs.getString(2);
				String city=rs.getString(3);
				Student std=new Student(rollNo, name, city);
				student.add(std);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public Student getOne(Integer rollNo) {
	Student foundStudent=null;
	String sQuery="Select * from stud where rollNo ?";
	try (
		Connection stdConnection=studUtils.buildConnection();
			PreparedStatement pstmt = stdConnection.prepareStatement(sQuery)
			){
		pstmt.setInt(1, rollNo);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			int roll=rs.getInt(1);
			String name=rs.getString(2);
			String city=rs.getString(3);
			foundStudent = new Student(roll, name, city);
			
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.getStackTrace();
	}
		return foundStudent;
	}

	@Override
	public void add(Student s) {
		String sqlQ="insert into stud values(?,?,?)";
		try (
				Connection stdConnection=studUtils.buildConnection();
					PreparedStatement pstmt = stdConnection.prepareStatement(sqlQ);
					){
			int rollN=s.getRollNo();
			String name=s.getName();
			String city=s.getCity();
			
			pstmt.setInt(1, rollN);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			
			int updateCount=pstmt.executeUpdate();
			System.out.println(updateCount+"Record Inserted");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
	}





}
