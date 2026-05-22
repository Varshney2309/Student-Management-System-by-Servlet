package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Course;
import com.studentcourse.util.DBConnection;

public class CourseDAO {

	// ADD COURSE
	public boolean addCourse(Course c) {

		boolean status = false;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "insert into courses(course_name,duration,fees,trainer_name) values(?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, c.getCourseName());

			preparedStatement.setString(2, c.getDuration());

			preparedStatement.setDouble(3, c.getFees());

			preparedStatement.setString(4, c.getTrainerName());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				status = true;
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return status;
	}

	// VIEW ALL COURSES
	public List<Course> getAllCourses() {

		List<Course> list = new ArrayList<>();

		try {

			Connection connection = DBConnection.getConnection();

			String query = "select * from courses";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resulSet = preparedStatement.executeQuery();

			while (resulSet.next()) {

				Course course = new Course();

				course.setCourseId(resulSet.getInt("course_id"));

				course.setCourseName(resulSet.getString("course_name"));

				course.setDuration(resulSet.getString("duration"));

				course.setFees(resulSet.getDouble("fees"));

				course.setTrainerName(resulSet.getString("trainer_name"));

				list.add(course);
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return list;
	}

	// GET COURSE BY ID
	public Course getCourseById(int courseId) {

		Course course = null;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "select * from courses where course_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, courseId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				course = new Course();

				course.setCourseId(resultSet.getInt("course_id"));

				course.setCourseName(resultSet.getString("course_name"));

				course.setDuration(resultSet.getString("duration"));

				course.setFees(resultSet.getDouble("fees"));

				course.setTrainerName(resultSet.getString("trainer_name"));
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return course;
	}

	// UPDATE COURSE
	public boolean updateCourse(Course course) {

		boolean status = false;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "update courses set course_name=?, duration=?, fees=?, trainer_name=? where course_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, course.getCourseName());

			preparedStatement.setString(2, course.getDuration());

			preparedStatement.setDouble(3, course.getFees());

			preparedStatement.setString(4, course.getTrainerName());

			preparedStatement.setInt(5, course.getCourseId());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				status = true;
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return status;
	}

	// DELETE COURSE
	public boolean deleteCourse(int courseId) {

		boolean status = false;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "delete from courses where course_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, courseId);

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