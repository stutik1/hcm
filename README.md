# Human Capital Management Application 

Web application code to expose API to create, update ,delete and read employee data in database. Using  technology java, Springboot, Postgre DB , JDBC template. Step by step instruction to develop and run the application.

#### Step 1: Set up the Spring Boot Project
- Open your Integrated Development Environment (IDE) and create a new Spring Boot project.
- Add the necessary Spring Boot and JDBC template dependencies similar to [pom.xml](pom.xml) file.

#### Step 2: Create Employee Entity and Database Table
- Create an [Employee](src/main/java/com/stuti/hcm/Employee.java) entity class representing the employee data in the src/main/java directory.
- Create a database table for the Employee entity using a [SQL script](). Execute the script in PostgreSQL database.

#### Step 3:  Implement EmployeeRepository with JDBC Template.

#### Step 4: Implement EmployeeService

#### Step 5: Implement EmployeeController

#### Step 6: Run the Application
- Run the Spring Boot application using your IDE's "Run" or "Debug" configuration.
- The application should start, and you can access the API endpoints at http://localhost:8080/api/employee.
- Use postman app to run the [API Collection of this app](src/main/resources/HCM_API.postman_collection.json)

With these steps, we have created a web application exposing APIs to create, update, delete, and read employee data using Java, Spring Boot, PostgreSQL, and JDBC template. Now we can use tools like Postman to test the API endpoints and perform CRUD operations on the employee data.
