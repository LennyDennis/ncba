### Running The Application

### Prerequisites
1. **Install Java Development Kit (JDK):**
    - Ensure JDK 17 is installed on your machine.
    - Set the `JAVA_HOME` environment variable.

2. **Install Maven:**
    - Ensure Maven is installed and configured on your machine.

### Running the Application

1. **Navigate to the Project Directory:**
   Open a terminal and navigate to the root directory of your Spring Boot project.

2. **Clean and Build the Project:**
   ```sh
   mvn clean install
   ```
   This command cleans the target directory, compiles the project, and packages the application into a JAR file named `ncba-0.0.1-SNAPSHOT.jar`.

3. **Run the Application:**
   You have two options to run your Spring Boot application:

   **Option 1: Using Maven Plugin**
   ```sh
   mvn spring-boot:run
   ```
   This command runs your application directly.

   **Option 2: Running the Packaged JAR**
    - Locate the JAR file in the `target` directory after the build.
    - Run the JAR file using the `java` command:
      ```sh
      java -jar target/ncba-0.0.1-SNAPSHOT.jar
      ```

### Postman Documentation

1. **Accessing Postman Documentation:**
    - The application's API documentation is available on Postman at [this link](https://documenter.getpostman.com/view/17519872/2sA3dxDris).
    - Use this documentation to understand the available endpoints, request methods, parameters, and sample responses.

