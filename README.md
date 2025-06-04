# 📘 Student Management System

A **Student Management System** web application designed to efficiently manage student information, grades, and user roles (Admin, Teacher, Student).  
This project is built using **Java, JSP, HTML, CSS, JavaScript, AJAX**, and a **MySQL database**.  
It allows for the management of student records, role-based access, and basic **CRUD** (Create, Read, Update, Delete) functionalities.

---

## 🌟 Features

### 👨‍🏫 Admin Role:
- Add student details such as name, roll number, class, and section.
- Manage student records (CRUD operations).

### 👩‍🏫 Teacher Role:
- Insert marks for students based on roll numbers.
- Ensure data consistency by verifying roll numbers from the database.

### 👨‍🎓 Student Role:
- View marks and personal details.

### 🔍 Search Functionality:
- Search for student data or marks by roll number.
- User-specific results with an interactive interface.

---

## 🛠️ Tech Stack

- **Frontend**: HTML, CSS  
- **Backend**: Java, Servlets, JSP  
- **Database**: MySQL (with JDBC for database connectivity)  
- **IDE**: NetBeans  
- **Version Control**: Git & GitHub  

---
## 📸 Screenshots

###  Registration Page
![Screenshot 2024-11-09 135219](https://github.com/user-attachments/assets/01afd06e-d9f4-4a95-8018-1a58c21ed9dd)

### 🔐 Login Page
![Screenshot 2024-11-09 135319](https://github.com/user-attachments/assets/b9374a9a-8385-45fd-9bb4-68cd46db4618)

### 🏠 Admin Dashboard
![Admin Dashboard](https://github.com/user-attachments/assets/63d6e49d-a4f5-48a1-898d-a687af48e466)

### Add Students Page
![Add Students](https://github.com/user-attachments/assets/354c9c97-c1c8-4fbb-9f9e-5271d7e9085e)

### Search Student Data and Marks Page
![Search Student Data and Marks](https://github.com/user-attachments/assets/d7a51c35-c689-4823-8274-03e1c6e832b3)

### Update Student Marks Page
![Update Student Marks](https://github.com/user-attachments/assets/e8a8356b-b988-4cc4-a4a6-e69b48c2ccbf)

### 📅 Teacher Dashboard
![Teacher Dashboard](https://github.com/user-attachments/assets/462c8d28-807a-40cc-8936-a22d65d95f37)

### Add Students Marks Page
![Add Students Marks](https://github.com/user-attachments/assets/13a877f0-0444-431b-ab2c-93133b7b3811)

### 📅 Student Dashboard
![Student Dashboard](https://github.com/user-attachments/assets/12f3f0a1-baed-4425-953a-97ea11461bdd)




## 🚀 Key Highlights

- **Role-Based Access**: Ensures that each user (Admin, Teacher, Student) has specific permissions.
- **Data Integrity**: Validates inputs to prevent errors, such as duplicate roll numbers or invalid entries.
- **Interactive UI**: Simple yet user-friendly interface with search and validation features.
- **Scalability**: Easily adaptable to larger datasets and additional functionalities.

---

## 📂 Project Structure

```
StudentManagementSystem/
│
├── 📁 src/
│   └── main/
│       └── java/                  # Java servlet and backend logic
│
├── 🌐 webapp/
│   ├── 📄 HTML, JSP, CSS files     # Frontend
│
├── 🗄️ database.sql                # MySQL database schema
└── 📄 README.md                   # This README file
```

---

## 🌐 Demo

- **Login Page**: Authenticate users based on roles (Admin, Teacher, Student).
- **Admin Page**: Manage student records and perform CRUD operations.
- **Teacher Page**: Insert and manage marks for students.
- **Student Page**: View marks and personal details.

---

## 🔒 Security Features

- Authentication and authorization for all users.
- Input validation to ensure clean data.
- Protection against SQL injection.

---

## 🤝 Contribution

Contributions are welcome! Feel free to fork this repository and submit pull requests.
