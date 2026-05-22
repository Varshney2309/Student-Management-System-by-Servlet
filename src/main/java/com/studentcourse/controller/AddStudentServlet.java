package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/add")
public class AddStudentServlet extends HttpServlet {

	@Override
	public void init() {

		System.out.println("AddStudentServlet Initialized");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {

			response.sendRedirect("../login");

			return;
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/student-form.jsp");

		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentName = request.getParameter("studentName");

		String email = request.getParameter("email");

		String phone = request.getParameter("phone");

		int age = Integer.parseInt(request.getParameter("age"));

		String city = request.getParameter("city");
		if (studentName.isEmpty() || email.isEmpty() || phone.isEmpty() || city.isEmpty()) {

			request.setAttribute("error", "All fields are required");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/student-form.jsp");

			requestDispatcher.forward(request, response);

			return;
		}

		if (!email.endsWith("@gmail.com")) {

			request.setAttribute("error", "Invalid Email");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/student-form.jsp");

			requestDispatcher.forward(request, response);

			return;
		}

		if (phone.length() != 10) {

			request.setAttribute("error", "Phone must be 10 digits");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/student-form.jsp");

			requestDispatcher.forward(request, response);

			return;
		}

		// VALIDATION
		if (age < 18) {

			request.setAttribute("error", "Age must be 18 or above");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/student-form.jsp");

			requestDispatcher.forward(request, response);

			return;
		}

		Student student = new Student();

		student.setStudentName(studentName);

		student.setEmail(email);

		student.setPhone(phone);

		student.setAge(age);

		student.setCity(city);

		StudentDAO dao = new StudentDAO();

		boolean status = dao.addStudent(student);

		if (status) {

			response.sendRedirect("../students");

		} else {

			request.setAttribute("error", "Student Add Failed");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/student-form.jsp");

			requestDispatcher.forward(request, response);
		}
	}

	@Override
	public void destroy() {

		System.out.println("AddStudentServlet Destroyed");
	}
}