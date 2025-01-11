# Admin Pannel

## Description

**Admin Pannel** is a web application that allows managing customer records through an interactive table supporting all CRUD operations (Create, Read, Update, Delete). It also implements user authentication and login management to ensure that only authorized users can access the system.

## Technologies Used

### Backend:
- **Java**
- **Spring Boot**
- **JPA (Java Persistence API)**
- **Hibernate**
- **MySQL**
- **Spring Security**
- **JWT (JSON Web Tokens)**

### Frontend:
- **JavaScript**
- **Bootstrap**

## Key Features

- **User Authentication**: Secure login system implementation using JWT.
- **CRUD Operations**: Create, read, update, and delete customer records.
- **User-Friendly Interface**: Frontend developed with Bootstrap for an intuitive user experience.
- **User Signup and Login**: Users can be created via the signup and login pages to access the system.

## Installation

### Prerequisites:
- **Java 8 or higher**
- **Maven**
- **MySQL**

### Installation Steps:

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/JTarangoDev/admin-pannel.git
    cd admin-pannel
    ```

2. **Configure the Database**:
    - Create a MySQL database and update the `application.properties` file in the `src/main/resources` directory with your MySQL credentials.

3. **Build and Run the Backend**:
    ```bash
    mvn spring-boot:run
    ```
## Usage

Once the system is running, you can access the admin panel from your browser at `http://localhost:8080/login.html`.

### Authentication
- **Register Endpoint**: `/api/auth/register`
- **Authentication Endpoint**: `/api/auth/login`
- **Provide Credentials**: Username and password to receive a JWT token for accessing protected routes.

### User Signup and Login
- Users can create accounts through the signup page and log in using the login page to access the system.

## Contact
For any questions, you can contact the project author at [jav.tarango@gmail.com](jav.tarango@gmail.com).
