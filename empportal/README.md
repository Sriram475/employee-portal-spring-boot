# 👨‍💼 Employee Portal

### 🚀 Spring Boot REST API for Employee Management

A simple and efficient **Employee Management REST API** built using **Java, Spring Boot, Spring Data JPA, Hibernate, MySQL, and Lombok**.

The application provides complete **CRUD operations** for employee records through RESTful APIs and follows a clean **Controller → Service → Repository → Database** architecture.

---

## 🏷️ Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-BC4521?style=for-the-badge&logo=lombok&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

---

## 📌 Project Overview

**Employee Portal** is a backend REST API application developed using Spring Boot.

The main purpose of this project is to manage employee information stored in a **MySQL database**.

The application supports:

- 👀 View all employees
- 🔍 View an employee by ID
- ➕ Create a new employee
- ✏️ Update employee information
- 🗑️ Delete an employee
- 💾 Store employee information in MySQL
- 🔄 Perform database operations using Spring Data JPA

---

# ✨ Features

### 👤 Employee Management

The application provides five main REST APIs:

| Feature | HTTP Method | Endpoint |
|---|---|---|
| 📋 Get all employees | `GET` | `/getEmpList` |
| 🔍 Get employee by ID | `GET` | `/getEmp/{eid}` |
| ➕ Create employee | `POST` | `/createEmp` |
| ✏️ Update employee | `PUT` | `/updateEmp/{eid}` |
| 🗑️ Delete employee | `DELETE` | `/delEmp/{eid}` |

---

# 🏗️ Architecture

The project follows a simple layered architecture:

```text
                    👨‍💻 Client
                       │
                       │ HTTP Request
                       ▼
              ┌───────────────────┐
              │   🎮 Controller    │
              │ HelloController   │
              └─────────┬─────────┘
                        │
                        ▼
              ┌───────────────────┐
              │   ⚙️ Service      │
              │ EmployeeService  │
              └─────────┬─────────┘
                        │
                        ▼
              ┌───────────────────┐
              │   🗄️ Repository    │
              │  EmployeeRepo    │
              └─────────┬─────────┘
                        │
                        ▼
              ┌───────────────────┐
              │ Spring Data JPA  │
              └─────────┬─────────┘
                        │
                        ▼
              ┌───────────────────┐
              │    Hibernate     │
              │       ORM        │
              └─────────┬─────────┘
                        │
                        ▼
              ┌───────────────────┐
              │     🐬 MySQL      │
              │      sbData       │
              └───────────────────┘
```

---

# 🔄 Application Flow

For example, when a user sends:

```http
GET /getEmpList
```

the request follows:

```text
Client
  ↓
HelloController
  ↓
EmployeeService
  ↓
EmployeeRepo
  ↓
Spring Data JPA
  ↓
Hibernate
  ↓
MySQL
  ↓
Employee Data
  ↓
JSON Response
```

This separation keeps the application organized and makes each layer responsible for a specific task.

---

# 📁 Project Structure

```text
empportal/
│
├── 📁 src/
│   └── 📁 main/
│       │
│       ├── 📁 java/
│       │   └── 📁 com/
│       │       └── 📁 spring/
│       │           └── 📁 empportal/
│       │               │
│       │               ├── 🚀 EmpportalApplication.java
│       │               │
│       │               ├── 📁 controller/
│       │               │   └── 🎮 HelloController.java
│       │               │
│       │               ├── 📁 service/
│       │               │   └── ⚙️ EmployeeService.java
│       │               │
│       │               ├── 📁 model/
│       │               │   └── 👤 Employee.java
│       │               │
│       │               └── 📁 repo/
│       │                   └── 🗄️ EmployeeRepo.java
│       │
│       └── 📁 resources/
│           └── ⚙️ application.properties
│
├── 📄 pom.xml
└── 📄 README.md
```

---

# 🧩 Project Components

## 🚀 1. EmpportalApplication

This is the main Spring Boot application class.

```java
@SpringBootApplication
public class EmpportalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpportalApplication.class, args);
    }
}
```

### Responsibility

- Starts the Spring Boot application
- Enables Spring Boot auto-configuration
- Scans the project for Spring components

---

# 🎮 2. Controller Layer

### `HelloController.java`

The Controller handles HTTP requests and maps them to the appropriate service methods.

```java
@RestController
public class HelloController {
```

### APIs implemented

```java
@GetMapping("/getEmpList")
```

```java
@GetMapping("/getEmp/{eid}")
```

```java
@PostMapping("/createEmp")
```

```java
@PutMapping("/updateEmp/{eid}")
```

```java
@DeleteMapping("/delEmp/{eid}")
```

The Controller does not directly perform database operations.

Instead:

```text
Controller
     ↓
EmployeeService
```

---

# ⚙️ 3. Service Layer

### `EmployeeService.java`

The Service layer contains the application's employee-related operations.

```java
@Service
public class EmployeeService {
```

It communicates with:

```text
EmployeeService
       ↓
EmployeeRepo
```

### Operations implemented

```java
getAllEmployeeDetails()
```

```java
getEmployee()
```

```java
createEmployee()
```

```java
updateEmployee()
```

```java
deleteEmployee()
```

---

# 🗄️ 4. Repository Layer

### `EmployeeRepo.java`

The repository extends:

```java
JpaRepository<Employee, Integer>
```

```java
@Repository
public interface EmployeeRepo
        extends JpaRepository<Employee, Integer> {
}
```

Because it extends `JpaRepository`, the project gets built-in methods such as:

```text
findAll()
findById()
save()
deleteById()
```

This allows the application to perform database CRUD operations without manually writing SQL for these operations.

---

# 👤 5. Employee Model

### `Employee.java`

The Employee class represents an employee record.

```java
@Entity
@Table(name = "employee79")
@Data
public class Employee {
```

### Fields

| Field | Java Type | Purpose |
|---|---|---|
| `eid` | `Integer` | Employee ID |
| `ename` | `String` | Employee name |
| `salary` | `Double` | Employee salary |
| `age` | `Integer` | Employee age |
| `city` | `String` | Employee city |
| `state` | `String` | Employee state |

---

# 🏷️ JPA Annotations Used

## `@Entity`

```java
@Entity
```

Marks `Employee` as a JPA entity.

---

## `@Table`

```java
@Table(name = "employee79")
```

Maps the Java entity to the MySQL table:

```text
employee79
```

---

## `@Id`

```java
@Id
Integer eid;
```

Defines `eid` as the primary key.

---

## `@GeneratedValue`

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

Allows the database to automatically generate employee IDs.

---

## `@Data`

```java
@Data
```

Lombok automatically generates getters, setters, `toString()`, `equals()`, and `hashCode()` methods.

---

# 🐬 Database

The project uses:

```text
MySQL
```

Database:

```text
sbData
```

Table:

```text
employee79
```

### Database Structure

```text
employee79
│
├── eid
├── ename
├── salary
├── age
├── city
└── state
```

---

# ⚙️ Database Configuration

The application uses the following configuration:

```properties
spring.application.name=empportal

server.port=9000

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/sbData
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> 🔐 Replace `your_password` with your local MySQL password.

---

# 🔧 Configuration Explanation

### Application Name

```properties
spring.application.name=empportal
```

Defines the Spring Boot application name.

### Server Port

```properties
server.port=9000
```

The application runs on:

```text
http://localhost:9000
```

### MySQL Database

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sbData
```

The application connects to:

```text
MySQL
   ↓
localhost
   ↓
Port 3306
   ↓
Database sbData
```

### Hibernate Schema Management

```properties
spring.jpa.hibernate.ddl-auto=update
```

Hibernate automatically updates the database schema based on the entity.

### SQL Logging

```properties
spring.jpa.show-sql=true
```

Displays SQL generated by Hibernate in the console.

---

# 🌐 REST API Documentation

Base URL:

```text
http://localhost:9000
```

---

## 📋 1. Get All Employees

### Endpoint

```http
GET /getEmpList
```

### Full URL

```text
http://localhost:9000/getEmpList
```

### Example Response

```json
[
    {
        "eid": 1,
        "ename": "Ravi",
        "salary": 45000.0,
        "age": 24,
        "city": "Hyderabad",
        "state": "Telangana"
    }
]
```

---

# 🔍 2. Get Employee By ID

### Endpoint

```http
GET /getEmp/{eid}
```

### Example

```text
http://localhost:9000/getEmp/1
```

### Response

```json
{
    "eid": 1,
    "ename": "Ravi",
    "salary": 45000.0,
    "age": 24,
    "city": "Hyderabad",
    "state": "Telangana"
}
```

---

# ➕ 3. Create Employee

### Endpoint

```http
POST /createEmp
```

### URL

```text
http://localhost:9000/createEmp
```

### Request Body

```json
{
    "ename": "Sriram",
    "salary": 50000.0,
    "age": 23,
    "city": "Hyderabad",
    "state": "Telangana"
}
```

### Example Response

```json
{
    "eid": 2,
    "ename": "Sriram",
    "salary": 50000.0,
    "age": 23,
    "city": "Hyderabad",
    "state": "Telangana"
}
```

---

# ✏️ 4. Update Employee

### Endpoint

```http
PUT /updateEmp/{eid}
```

### Example

```text
http://localhost:9000/updateEmp/1
```

### Request Body

```json
{
    "ename": "Sriram Kumar",
    "salary": 60000.0,
    "age": 24,
    "city": "Hyderabad",
    "state": "Telangana"
}
```

### Update Flow

```text
eid
 ↓
Find existing employee
 ↓
Update employee fields
 ↓
save()
 ↓
Database
```

The following fields are updated:

```text
ename
salary
age
city
state
```

---

# 🗑️ 5. Delete Employee

### Endpoint

```http
DELETE /delEmp/{eid}
```

### Example

```text
http://localhost:9000/delEmp/1
```

### Response

```text
Employee has been deleted successfully with id of !!1
```

---

# 📊 API Summary

| # | Method | Endpoint | Description |
|---|---|---|---|
| 1️⃣ | `GET` | `/getEmpList` | Get all employees |
| 2️⃣ | `GET` | `/getEmp/{eid}` | Get employee by ID |
| 3️⃣ | `POST` | `/createEmp` | Create employee |
| 4️⃣ | `PUT` | `/updateEmp/{eid}` | Update employee |
| 5️⃣ | `DELETE` | `/delEmp/{eid}` | Delete employee |

---

# 🧪 API Testing

The APIs can be tested using **Postman**.

### Example CRUD Testing Flow

```text
1️⃣ POST
   ↓
Create Employee

2️⃣ GET
   ↓
View Employee

3️⃣ PUT
   ↓
Update Employee

4️⃣ GET
   ↓
Verify Updated Employee

5️⃣ DELETE
   ↓
Delete Employee

6️⃣ GET
   ↓
Verify Employee Deletion
```

---

# 📸 Screenshots

Add your project screenshots here after testing the APIs in Postman.

## 🏠 Project Structure

> 📷 Add screenshot of your Eclipse/IntelliJ project structure here.

```text
docs/screenshots/project-structure.png
```

---

## ➕ Create Employee

> 📷 Add your Postman POST request screenshot here.

```text
docs/screenshots/create-employee.png
```

---

## 📋 Get All Employees

> 📷 Add your GET request screenshot here.

```text
docs/screenshots/get-all-employees.png
```

---

## 🔍 Get Employee By ID

> 📷 Add your GET-by-ID screenshot here.

```text
docs/screenshots/get-employee.png
```

---

## ✏️ Update Employee

> 📷 Add your PUT request screenshot here.

```text
docs/screenshots/update-employee.png
```

---

## 🗑️ Delete Employee

> 📷 Add your DELETE request screenshot here.

```text
docs/screenshots/delete-employee.png
```

---

# 🚀 How to Run the Project

## 1️⃣ Clone the Repository

```bash
git clone <your-github-repository-url>
```

Navigate into the project:

```bash
cd empportal
```

---

## 2️⃣ Create MySQL Database

Open MySQL and execute:

```sql
CREATE DATABASE sbData;
```

Verify:

```sql
SHOW DATABASES;
```

---

## 3️⃣ Configure MySQL Credentials

Open:

```text
src/main/resources/application.properties
```

Update:

```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

with your MySQL credentials.

---

## 4️⃣ Run the Application

Run:

```text
EmpportalApplication.java
```

or using Maven:

```bash
mvn spring-boot:run
```

---

## 5️⃣ Verify Application

Open:

```text
http://localhost:9000/getEmpList
```

If the application is running correctly, the API will return the employee records.

---

# 🔄 CRUD Operation Flow

The project implements the four fundamental database operations:

```text
        EMPLOYEE CRUD
             │
     ┌───────┼────────┐
     │       │        │
     ▼       ▼        ▼
  CREATE    READ    UPDATE
     │       │        │
     └───────┼────────┘
             │
             ▼
           DELETE
```

### CREATE

```text
POST /createEmp
```

### READ

```text
GET /getEmpList
GET /getEmp/{eid}
```

### UPDATE

```text
PUT /updateEmp/{eid}
```

### DELETE

```text
DELETE /delEmp/{eid}
```

---

# 🧠 Concepts Used

This project demonstrates practical knowledge of:

### ☕ Java

- Classes
- Objects
- Methods
- Interfaces
- Packages
- Generics

### 🌱 Spring Boot

- `@SpringBootApplication`
- `@RestController`
- `@Service`
- `@Repository`
- Dependency Injection
- `@Autowired`

### 🌐 Spring Web

- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`
- `@PathVariable`
- `@RequestBody`

### 🗄️ Spring Data JPA

- `JpaRepository`
- `findAll()`
- `findById()`
- `save()`
- `deleteById()`

### 🐬 MySQL

- Database
- Tables
- Primary Key
- Persistent employee data

### 🔄 Hibernate

- ORM
- Entity mapping
- Database interaction
- Automatic schema update

### 🏷️ Lombok

- `@Data`
- Automatic getters/setters
- Reduced boilerplate code

---

# 🔐 Current Project Scope

This project currently focuses specifically on:

```text
✅ Employee CRUD
✅ REST APIs
✅ Spring Boot
✅ Spring Data JPA
✅ Hibernate
✅ MySQL
✅ Lombok
✅ Postman API testing
```

The following are **not part of the current implementation**:

```text
❌ Spring Security
❌ JWT Authentication
❌ React Frontend
❌ Swagger/OpenAPI
❌ DTO Layer
❌ Global Exception Handler
❌ Pagination
❌ Search API
❌ Sorting API
```

These can be added later as enhancements, but they are intentionally not presented as existing features.

---

# 💼 Portfolio Description

### 👨‍💻 Employee Portal — Spring Boot REST API

A backend employee management application developed using **Java and Spring Boot**.

The project implements RESTful CRUD APIs and uses **Spring Data JPA with Hibernate** to persist employee information in a **MySQL database**. The application follows a layered architecture consisting of Controller, Service, Repository, and Model layers.

### Key Highlights

- 🚀 Built REST APIs using Spring Boot
- 🔄 Implemented complete CRUD operations
- 🗄️ Integrated MySQL using Spring Data JPA
- 🔗 Used Hibernate for ORM and entity mapping
- 🧩 Followed Controller-Service-Repository architecture
- 🧪 Tested REST endpoints using Postman
- 🏷️ Used Lombok to reduce Java boilerplate code

---

# 📄 Resume Project Description

You can use this version directly on your resume:

> **Employee Portal | Java, Spring Boot, Spring Data JPA, Hibernate, MySQL**
>
> • Developed a RESTful Employee Management API using Spring Boot to perform CRUD operations for employee records.  
> • Implemented Controller-Service-Repository architecture using Spring Web and Spring Data JPA.  
> • Integrated MySQL with Hibernate ORM for persistent employee data management and tested APIs using Postman.

---

# 🎤 Interview Explanation

If an interviewer asks:

### "Explain your Employee Portal project."

You can say:

> "I developed an Employee Portal using Java and Spring Boot to manage employee records through REST APIs. The application performs CRUD operations such as creating, retrieving, updating, and deleting employees. I used Spring Web for REST API development, Spring Data JPA and Hibernate for database interaction, and MySQL for data persistence. I followed a layered architecture with Controller, Service, Repository, and Model layers. I also used Lombok to reduce boilerplate code and tested the APIs using Postman."

---

# ⭐ What I Learned

Through this project, I gained practical experience with:

- 🌱 Spring Boot application development
- 🌐 REST API creation
- 🔄 CRUD operations
- 🗄️ Database integration
- 🔗 JPA and Hibernate
- 🧩 Layered architecture
- 💉 Dependency Injection
- 📦 Repository pattern
- 🧪 API testing with Postman
- 🐬 MySQL database connectivity

---

# 👨‍💻 Author

### Sriram Illingi

🎓 B.Tech — Information Technology

💻 Interested in:

```text
Java
Spring Boot
Backend Development
Full Stack Development
REST APIs
Database Technologies
```

---

# ⭐ If You Like This Project

If this project helped you understand Spring Boot CRUD operations, consider giving the repository a ⭐ on GitHub!

---

## 📌 Project Summary

```text
┌───────────────────────────────────────────────┐
│               👨‍💼 EMPLOYEE PORTAL             │
├───────────────────────────────────────────────┤
│                                               │
│  ☕ Java                                      │
│  🌱 Spring Boot                               │
│  🌐 REST API                                  │
│  🔄 CRUD Operations                           │
│  🗄️ Spring Data JPA                           │
│  🔗 Hibernate                                │
│  🐬 MySQL                                    │
│  🏷️ Lombok                                   │
│  🧪 Postman                                  │
│                                               │
├───────────────────────────────────────────────┤
│                                               │
│ Controller → Service → Repository → MySQL    │
│                                               │
└───────────────────────────────────────────────┘
```

---

### 🚀 Built with Java + Spring Boot + MySQL

**Simple architecture. Clean code. Practical REST API.**