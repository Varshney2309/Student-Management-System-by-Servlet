package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.model.Registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration/save")
public class RegisterStudentCourseServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studentId = Integer.parseInt(request.getParameter("studentId"));

		int courseId = Integer.parseInt(request.getParameter("courseId"));

		String registrationDate = request.getParameter("registrationDate");

		String status = request.getParameter("status");

		Registration registration = new Registration();

		if (registrationDate.isEmpty() || status.isEmpty()) {

			request.setAttribute("error", "All fields are required");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp");

			requestDispatcher.forward(request, response);

			return;
		}
		if (studentId <= 0) {

			request.setAttribute("error", "Invalid Student ID");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp");

			requestDispatcher.forward(request, response);

			return;
		}
		if (courseId <= 0) {

			request.setAttribute("error", "Invalid Course ID");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp");

			requestDispatcher.forward(request, response);

			return;
		}

		registration.setStudentId(studentId);

		registration.setCourseId(courseId);

		registration.setRegistrationDate(registrationDate);

		registration.setStatus(status);

		RegistrationDAO dao = new RegistrationDAO();

		boolean result = dao.addRegistration(registration);

		if (result) {

			response.sendRedirect("../registrations");

		} else {

			request.setAttribute("error", "Registration Failed");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp");

			requestDispatcher.forward(request, response);
		}
	}
}