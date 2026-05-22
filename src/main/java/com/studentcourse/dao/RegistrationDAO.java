package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Registration;
import com.studentcourse.util.DBConnection;

public class RegistrationDAO {

	// ADD REGISTRATION
	public boolean addRegistration(Registration r) {

		boolean status = false;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "insert into registrations(student_id,course_id,registration_date,status) values(?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, r.getStudentId());

			preparedStatement.setInt(2, r.getCourseId());

			preparedStatement.setString(3, r.getRegistrationDate());

			preparedStatement.setString(4, r.getStatus());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				status = true;
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return status;
	}

	// VIEW ALL REGISTRATIONS
	public List<Registration> getAllRegistrations() {

		List<Registration> list = new ArrayList<>();

		try {

			Connection connection = DBConnection.getConnection();

			String query = "select * from registrations";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Registration registration = new Registration();

				registration.setRegistrationId(resultSet.getInt("registration_id"));

				registration.setStudentId(resultSet.getInt("student_id"));

				registration.setCourseId(resultSet.getInt("course_id"));

				registration.setRegistrationDate(resultSet.getString("registration_date"));

				registration.setStatus(resultSet.getString("status"));

				list.add(registration);
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return list;
	}

	// UPDATE STATUS
	public boolean updateRegistrationStatus(int registrationId, String statusValue) {

		boolean status = false;

		try {

			Connection connection = DBConnection.getConnection();

			String query = "update registrations set status=? where registration_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, statusValue);

			preparedStatement.setInt(2, registrationId);

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				status = true;
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		}

		return status;
	}

	// DELETE REGISTRATION
	public boolean deleteRegistration(int registrationId) {

		boolean status = false;

		try {

			Connection connection= DBConnection.getConnection();

			String query = "delete from registrations where registration_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, registrationId);

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