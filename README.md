# EBook Management System

#### **Overview**

This project is a **Java-based** EBook Management System designed to manage eBooks, including their addition, updating, and deletion. It allows users to:

- Add new eBooks with their details (Title, Author, Price, Edition).
- View the list of all available eBooks.
- Edit or delete existing eBooks.

The application uses **MySQL** as the database for persistent storage and **JSP** & **Servlets** for server-side rendering of the frontend.

---

#### **Features**

##### 1. **Add EBook:**
- Add new eBooks with their **Name**, **Edition**, and **Price**.
- Form validation ensures all fields are filled.

##### 2. **View EBook List:**
- Display a list of all eBooks with their details (**Name**, **Edition**, **Price**).

##### 3. **Edit EBook:**
- Edit the details of an existing eBook (**Name**, **Edition**, **Price**).

##### 4. **Delete EBook:**
- Delete an existing eBook from the system.

##### 5. **Persistent Storage:**
- Uses **MySQL** to store eBook data, ensuring data persistence across application restarts.

---

#### **Technologies Used**

##### Backend:
- **Java Servlets:** For handling HTTP requests and business logic.
- **JSP (JavaServer Pages):** For rendering dynamic HTML pages.
- **MySQL:** Relational database for persistent storage.

##### Frontend:
- **HTML:** Structure of the web pages.
- **CSS:** Basic styling for the web pages.
- **JSP:** Used for dynamic data rendering.

##### Tools:
- **Maven:** Dependency management and build tool.
- **MySQL Workbench:** For managing the MySQL database.

---

#### **Setup Instructions**

##### Prerequisites:
- **Java Development Kit (JDK):** Version 8 or higher.
- **MySQL:** Installed and running on your machine.
- **Maven:** Installed for dependency management.
- **IDE:** Any Java IDE (e.g., IntelliJ IDEA, Eclipse).
- **Apache Tomcat:** For running the web application.

##### 1. **Import the project:**
Import the project into your IDE or download it from GitHub.

##### 2. Set Up MySQL Database:**
# Open MySQL and create a new database
CREATE DATABASE ebook_management_db;

# Create the table within the new database
CREATE TABLE ebooks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    edition VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

##### 4. Deploy the Application**
Change the names of the Database and Table in the code where ever necessary.

##### 3. Deploy the Application**
 Deploy the project on Apache Tomcat
 You can either run it through your IDE or manually deploy the WAR file to Tomcat.
