# Student Management System by Servlet

A web-based Student Management System developed using Java Servlets, JSP, JDBC, and MySQL.
This project allows Admin to manage Students, Courses, and Course Registrations.

---

# Features

## Admin Module

* Admin Login
* Remember Username using Cookies
* Logout Functionality
* Session Management

---

## Student Module

* Add Student
* View All Students
* Edit Student
* Delete Student

### Validations

* Required Fields
* Email Validation
* Phone Number Validation
* Age Validation

---

## Course Module

* Add Course
* View Courses
* Update Course
* Delete Course

### Validations

* Required Fields
* Minimum Fees Validation
* Future Date Restriction

---

## Registration Module

* Register Student to Course
* View Registrations
* Update Registration Status
* Delete Registration

---

# Technologies Used

* Java
* Servlet
* JSP
* JDBC
* MySQL
* HTML
* CSS
* Apache Tomcat
* Eclipse IDE

---

# Database

## Database Name

```sql
student_course_db
```

---

# Tables

* admin
* student
* course
* registration

---

# Admin Credentials

```text
Username : admin
Password : admin123
```

---

# Project Structure

```text
StudentManagementSystembyServlet
│
├── src
│   └── main
│       ├── java
│       │
│       │   └── com.studentcourse
│       │
│       │       ├── controller
│       │       │
│       │       │   ├── LoginServlet.java
│       │       │   ├── LogoutServlet.java
│       │       │   ├── DashboardServlet.java
│       │       │
│       │       │   ├── AddStudentServlet.java
│       │       │   ├── ViewStudentsServlet.java
│       │       │   ├── EditStudentServlet.java
│       │       │   ├── UpdateStudentServlet.java
│       │       │   └── DeleteStudentServlet.java
│       │       │
│       │       │   ├── AddCourseServlet.java
│       │       │   ├── ViewCoursesServlet.java
│       │       │   ├── EditCourseServlet.java
│       │       │   ├── UpdateCourseServlet.java
│       │       │   └── DeleteCourseServlet.java
│       │       │
│       │       │   ├── RegistrationFormServlet.java
│       │       │   ├── RegisterStudentCourseServlet.java
│       │       │   ├── ViewRegistrationsServlet.java
│       │       │   ├── UpdateRegistrationStatusServlet.java
│       │       │   └── DeleteRegistrationServlet.java
│       │
│       │       ├── dao
│       │       │
│       │       │   ├── AdminDAO.java
│       │       │   ├── StudentDAO.java
│       │       │   ├── CourseDAO.java
│       │       │   └── RegistrationDAO.java
│       │
│       │       ├── model
│       │       │
│       │       │   ├── Admin.java
│       │       │   ├── Student.java
│       │       │   ├── Course.java
│       │       │   └── Registration.java
│       │
│       │       └── util
│       │
│       │           └── DBConnection.java
│       │
│       └── webapp
│
│           ├── css
│           │
│           │   └── style.css
│           │
│           ├── WEB-INF
│           │   │
│           │   ├── web.xml
│           │   │
│           │   └── views
│           │
│           │       ├── login.jsp
│           │       ├── dashboard.jsp
│           │
│           │       ├── student-form.jsp
│           │       ├── student-list.jsp
│           │       ├── student-edit.jsp
│           │
│           │       ├── course-form.jsp
│           │       ├── course-list.jsp
│           │       ├── course-edit.jsp
│           │
│           │       ├── registration-form.jsp
│           │       ├── registration-list.jsp
│           │       └── registration-edit.jsp
│           │
│           └── META-INF
│
├── build
│
├── Libraries
│
├── Referenced Libraries
│
├── pom.xml
│
└── README.md
```


---

# How To Run

1. Clone the repository

```bash
git clone <repository-url>
```

2. Import project into Eclipse

3. Configure MySQL database

4. Add MySQL Connector JAR

5. Configure database credentials in:

```text
DBConnection.java
```

6. Run on Apache Tomcat Server

7. Open browser

```text
http://localhost:8080/StudentManagementSystembyServlet
```

---

# UI Features

* Custom CSS Styling
* Responsive Form Layout
* Styled Tables
* Delete Confirmation Popup
* Error Messages
* Remember Username Feature

---

# Security Features

* Session Validation
* Backend Validations
* Cookie Handling
* Protected Dashboard Access

---



# Author

Harshit Varshney

---
