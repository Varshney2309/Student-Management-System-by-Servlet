package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Student;
import com.studentcourse.util.DBConnection;

public class StudentDAO {

	// ADD STUDENT
	public boolean addStudent(Student s) {

		boolean status = false;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "insert into students(student_name,email,phone,age,city) values(?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, s.getStudentName());

			preparedStatement.setString(2, s.getEmail());

			preparedStatement.setString(3, s.getPhone());

			preparedStatement.setInt(4, s.getAge());

			preparedStatement.setString(5, s.getCity());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				status = true;
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return status;
	}

	// VIEW ALL STUDENTS
	public List<Student> getAllStudents() {

		List<Student> list = new ArrayList<>();

		try {

			Connection connection = DBConnection.getConnection();

			String query = "select * from students";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Student student = new Student();

				student.setStudentId(resultSet.getInt("student_id"));

				student.setStudentName(resultSet.getString("student_name"));

				student.setEmail(resultSet.getString("email"));

				student.setPhone(resultSet.getString("phone"));

				student.setAge(resultSet.getInt("age"));

				student.setCity(resultSet.getString("city"));

				list.add(student);
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return list;
	}

	// GET STUDENT BY ID
	public Student getStudentById(int studentId) {

		Student student = null;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "select * from students where student_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, studentId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				student = new Student();

				student.setStudentId(resultSet.getInt("student_id"));

				student.setStudentName(resultSet.getString("student_name"));

				student.setEmail(resultSet.getString("email"));

				student.setPhone(resultSet.getString("phone"));

				student.setAge(resultSet.getInt("age"));

				student.setCity(resultSet.getString("city"));
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return student;
	}

	// UPDATE STUDENT
	public boolean updateStudent(Student s) {

		boolean status = false;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "update students set student_name=?, email=?, phone=?, age=?, city=? where student_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, s.getStudentName());

			preparedStatement.setString(2, s.getEmail());

			preparedStatement.setString(3, s.getPhone());

			preparedStatement.setInt(4, s.getAge());

			preparedStatement.setString(5, s.getCity());

			preparedStatement.setInt(6, s.getStudentId());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				status = true;
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return status;
	}

	// DELETE STUDENT
	public boolean deleteStudent(int studentId) {

		boolean status = false;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "delete from students where student_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, studentId);

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				status = true;
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return status;
	}
}