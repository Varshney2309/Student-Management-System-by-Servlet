package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/course/add")
public class AddCourseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {

			response.sendRedirect("../login");

			return;
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/course-form.jsp");

		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String courseName = request.getParameter("courseName");

		String duration = request.getParameter("duration");

		double fees = Double.parseDouble(request.getParameter("fees"));

		String trainerName = request.getParameter("trainerName");

		if (courseName.isEmpty() || duration.isEmpty() || trainerName.isEmpty()) {

			request.setAttribute("error", "All fields are required");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/course-form.jsp");

			requestDispatcher.forward(request, response);

			return;
		}
		if (fees < 1000) {

			request.setAttribute("error", "Fees must be greater than 1000");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/course-form.jsp");

			requestDispatcher.forward(request, response);

			return;
		}

		Course course = new Course();

		course.setCourseName(courseName);

		course.setDuration(duration);

		course.setFees(fees);

		course.setTrainerName(trainerName);

		CourseDAO dao = new CourseDAO();

		boolean status = dao.addCourse(course);

		if (status) {

			response.sendRedirect("../courses");

		} else {

			request.setAttribute("error", "Course Add Failed");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/course-form.jsp");

			requestDispatcher.forward(request, response);
		}
	}
}