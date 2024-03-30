package org.example;
import java.io.*;
import java.util.*;

import static java.lang.System.exit;

// Abstract User class
abstract class User {
    private String name;
    private String username;
    private String password;

    // Constructor
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Abstract method for user menu
    public abstract void showMenu();
}

// Admin class
class Admin extends User {

    // Constructor
    public Admin(String name, String username, String password) {
        super(name, username, password);
    }

    // Override getPassword if necessary
    @Override
    public String getPassword() {
        return super.getPassword(); // Default implementation from User class
    }

    // Override abstract method
    @Override
    public void showMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Create a student account");
        System.out.println("2. Delete a student account");
        System.out.println("3. Create a teacher account");
        System.out.println("4. Delete a teacher account");
        System.out.println("5. Create a course");
        System.out.println("6. Delete a course");
        System.out.println("7. View all students");
        System.out.println("8. View all teachers");
        System.out.println("9. View all courses");
        System.out.println("10. Logout");

    }
}

public class Main {
    static String studentPassword;
    static String studentUsername;
    static String teacherUsername;
    static String teacherPassword;
    static String courseName;
    static List<String> courses;
    static List<Password> students;
    static List<Password> teachers;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String userType=null;

        while (true) {
            System.out.println("Login Menu:");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Teacher Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Admin login
                    System.out.print("Enter username: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String adminPassword = scanner.nextLine();

                    if (checkLogin("admin",adminUsername,adminPassword)) {

                        userType="admin";
                        System.out.println("Admin logged in successfully.");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 2:
                    // Student login
                    // Implement student login
                    // Admin login
                    System.out.print("Enter username: ");
                     studentUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                     studentPassword = scanner.nextLine();
                    if (checkLogin("student",studentUsername,studentPassword)) {

                        userType="student";
                        System.out.println("Admin logged in successfully.");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                 System.out.println("Student login functionality not implemented yet.");

                   break;
                   case 3:
                   // Teacher login
                       // Implement teacher login
                       System.out.print("Enter username: ");
                      teacherUsername = scanner.nextLine();
                       System.out.print("Enter password: ");
                      teacherPassword = scanner.nextLine();
                       if (checkLogin("teacher",teacherUsername,teacherPassword)) {

                           userType="teacher";
                           System.out.println("Teacher logged in successfully.");
                       } else {
                           System.out.println("Invalid username or password.");
                       }
                     break;
                case 4:
                    // Exit
                    System.out.println("Exiting program.");
                    exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

            // If a user is logged in, show their menu
            if(userType.equals("admin"))
            {
                while (true) {
                    showMenu();
                    System.out.print("Enter your choice: ");
                    int userChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Perform actions based on user choice
                    switch (userChoice) {
                        case 1:
                           // System.out.println("1. Create a student account.");
                            System.out.print("Enter username: ");
                            studentUsername = scanner.nextLine();
                            System.out.print("Enter password: ");
                            studentPassword = scanner.nextLine();

                            if(checkUser(studentUsername))
                            {
                                System.out.println("Already exist this User Name");
                            }
                            else {
                                addAccount("student",studentUsername,studentPassword);
                            }

                            break;
                        case 2:
                            System.out.print("Enter username: ");
                            studentUsername = scanner.nextLine();
                            deleteAccount("student",studentUsername);
                            break;
                        case 3:
                            System.out.print("Enter username: ");
                            teacherUsername = scanner.nextLine();
                            System.out.print("Enter password: ");
                            teacherPassword = scanner.nextLine();
                            if(checkUser(teacherUsername))
                            {
                            System.out.println("Already exist this User Name");
                            }
                            else {
                                addAccount("teacher",teacherUsername,teacherPassword);
                            }

                            break;
                        case 4:
                            System.out.print("Enter username: ");
                            teacherUsername = scanner.nextLine();
                            deleteAccount("teacher",teacherUsername);
                            break;
                        case 5:
                            System.out.print("Enter Course Name: ");
                            courseName = scanner.nextLine();
                            addCourse(courseName);

                            break;
                        case 6:
                            System.out.print("Enter Course Name: ");
                             courseName = scanner.nextLine();
                             deleteCourse(courseName);
                            break;
                        case 7:
                            printAllStudentUserName();
                            break;
                        case 8:
                            printAllTeachers();
                            break;
                        case 9:
                            printAllCourses();
                            break;
                        case 10:
                            // Logout
                            System.out.println("Logging out.");
                            exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number based on the menu.");
                    }


                }
            }
            else if(userType.equals("student"))
            {
                while (true) {
                   showStudentMenu();
                    System.out.print("Enter your choice: ");
                    int userChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Perform actions based on user choice
                    switch (userChoice) {
                        case 1:
                            // Handle Enroll in a course
                           // printAllCourses();
                            printNonEnrolledCourse(studentUsername);
                            System.out.print("Enter Course Name: ");
                            courseName = scanner.nextLine();
                            studentEnrollment(studentUsername,courseName);

                            break;
                        case 2:
                            // Handle Drop a course
                            printEnrolledCourse(studentUsername);
                            System.out.print("Enter Course Name: ");
                            courseName = scanner.nextLine();
                            deleteStudentEnrollment(studentUsername,courseName);

                            break;
                        case 3:
                            // Handle Check grades
                            printStudentGrade(studentUsername);
                            break;
                        case 4:
                            printEnrolledCourse(studentUsername);
                            break;
                        case 5:
                            // Handle Logout
                            System.out.println("Logout");
                            exit(0);
                            return; // Exit the while loop and method
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                }
            }
            else if(userType.equals("teacher"))
            {
                while (true) {
                    showTeacherMenu();
                    System.out.print("Enter your choice: ");
                    int userChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Perform actions based on user choice
                    switch (userChoice) {
                        case 1:
                            // Enroll in a course
                            printAllCourses();
                            System.out.print("Enter Course Name: ");
                            courseName = scanner.nextLine();
                            if(checkCourseExistence(courseName))
                            {
                                System.out.print("Already Course Enrolled ");

                            }else {
                                saveTeacherEnrollment(teacherUsername, courseName);
                            }


                            break;
                        case 2:
                            // Drop a course
                            printSingleUserEnrolledData(teacherUsername);
                            System.out.print("Enter Course Name: ");
                            courseName = scanner.nextLine();
                            deleteCourse(teacherUsername,courseName);
                            break;
                        case 3:
                            // Add students to a course
                            printSingleUserEnrolledData(teacherUsername);
                            System.out.print("Enter Course Name: ");
                            courseName = scanner.nextLine();
                            System.out.println("Student UserName: ");
                            printAllStudentUserName();
                            System.out.print("Enter username: ");
                            studentUsername = scanner.nextLine();
                            studentEnrollment(studentUsername,courseName);

                            break;
                        case 4:
                            // Remove students from a course
                            printSingleUserEnrolledData(teacherUsername);
                            System.out.print("Enter Course Name: ");
                            courseName = scanner.nextLine();
                            System.out.println("Student Information: ");
                            printAllStudentsByCourse(courseName);
                            //printAllStudentUserName(courseName);
                            System.out.print("Enter username: ");
                            studentUsername = scanner.nextLine();
                            deleteStudentEnrollment(studentUsername,courseName);
                            break;
                        case 5:
                            printSingleUserEnrolledData(teacherUsername);
                            System.out.print("Enter Course Name: ");
                            courseName = scanner.nextLine();
                            System.out.println("Student Information: ");
                            printAllStudentsByCourse(courseName);
                            //printAllStudentUserName(courseName);
                            System.out.print("Enter username: ");
                            studentUsername = scanner.nextLine();
                            System.out.print("Enter Grade: ");

                            String grade= scanner.nextLine();

                            saveGrade(studentUsername,courseName,grade);
                            // Assign grades to students
                            break;
                        case 6:
                            // View all students in a course
                            printSingleUserEnrolledData(teacherUsername);
                            System.out.print("Enter Course Name: ");
                            courseName = scanner.nextLine();
                            System.out.println("Student Information: ");
                            printAllStudentsByCourse(courseName);
                            break;
                        case 7:
                            // View all courses enrolled in
                            printSingleUserEnrolledData(teacherUsername);
                            break;
                        case 8:
                            System.out.println("Logging out...");
                            exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
            }
            else
            {

            }

        }
    }

    public static boolean checkLogin(String name,String username, String password) {
        String csvFile = "password.csv";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length == 3&& data[0].equals(name) && data[1].equals(username) && data[2].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void showMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Create a student account");
        System.out.println("2. Delete a student account");
        System.out.println("3. Create a teacher account");
        System.out.println("4. Delete a teacher account");
        System.out.println("5. Create a course");
        System.out.println("6. Delete a course");
        System.out.println("7. View all students");
        System.out.println("8. View all teachers");
        System.out.println("9. View all courses");
        System.out.println("10. Logout");
        // Add more options as needed
    }
    public static void showTeacherMenu() {
        System.out.println("Teacher Menu:");
        System.out.println("1. Enroll in a course");
        System.out.println("2. Drop a course");
        System.out.println("3. Add students to a course");
        System.out.println("4. Remove students from a course");
        System.out.println("5. Assign grades to students");
        System.out.println("6. View all students in a course");
        System.out.println("7. View all courses enrolled in");
        System.out.println("8. Logout");
        // Add more options as needed
    }
    public static void showStudentMenu() {
        System.out.println("Student Menu:");
        System.out.println("1. Enroll in a course");
        System.out.println("2. Drop a course");
        System.out.println("3. Check grades");
        System.out.println("4. View all courses enrolled in");
        System.out.println("5. Logout");
        // Add more options as needed
    }

    public static void addAccount(String name, String username, String password) {
        String csvFile = "password.csv";

        try (FileWriter fw = new FileWriter(csvFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(name + "," + username + "," + password);
            System.out.println("Account added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deleteAccount(String name,String username) {
        String csvFile = "password.csv";

        // Create a list to store Password objects
        List<Password> passwords = new ArrayList<>();

        // Read data from the CSV file and create Password objects
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    Password password = new Password(fields[0], fields[1], fields[2]);
                    passwords.add(password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Remove the Password object corresponding to the provided username
        Password accountToDelete = null;
        for (Password password : passwords) {
            if (password.getUsername().equals(username)&& password.getName().equals(name)) {
                accountToDelete = password;
                break;
            }
        }
        if (accountToDelete != null) {
            passwords.remove(accountToDelete);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
            return;
        }

        // Write the updated Password objects back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (Password password : passwords) {
                bw.write(password.getName() + "," + password.getUsername() + "," + password.getPassword());
                bw.newLine();
            }
            //System.out.println("Updated data written to file.");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


    }
    public static void addCourse(String courseName) {
        String csvFile = "courses.csv";

        // Check if the file exists to determine if the header needs to be written
        boolean fileExists = new File(csvFile).exists();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            if (!fileExists) {
                // Write the header if the file is new
                bw.write("CourseName");
                bw.newLine();
            }
            // Write the course name
            bw.write(courseName);
            bw.newLine();
            System.out.println("Course added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteCourse(String courseName) {
        String csvFile = "courses.csv";

        // Create a list to store course names
        List<String> courses = new ArrayList<>();

        // Read data from the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                courses.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Remove the course name from the list
        if (courses.remove(courseName)) {
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found.");
            return;
        }

        // Write the updated course names back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter( csvFile ))) {
            for (String course : courses) {
                bw.write(course);
                bw.newLine();
            }
            System.out.println("Updated data written to file.");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }
    public static List<Password> getTeachers() {
        teachers = new ArrayList<>();
        String csvFile = "password.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3 && fields[0].equals("teacher")) {
                    Password teacher = new Password(fields[0], fields[1], fields[2]);
                    teachers.add(teacher);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teachers;
    }
    public static void printAllTeachers() {
        teachers = getTeachers();
        for (Password teacher : teachers) {
            System.out.println("Name: " + teacher.getName() + ", Username: " + teacher.getUsername() + ", Password: " + teacher.getPassword());
        }
    }
    public static List<Password> getStudents() {
        students = new ArrayList<>();
        String csvFile = "password.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3 && fields[0].equals("student")) {
                    Password student = new Password(fields[0], fields[1], fields[2]);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
    public static void printAllStudentUserName() {
        students = getStudents();
        for (Password student : students) {
            System.out.println(student.getUsername());
        }
    }

    public static List<String> getCourses() {
      courses = new ArrayList<>();
        String csvFile = "courses.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                courses.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }
    public static void printNonEnrolledCourse(String userName) {
        courses=getNonEnrolledCourse(userName);
        System.out.println("All NonEnrolledCourse:");
        for (String course : courses) {
            System.out.println(course);
        }
    }
    public static void printEnrolledCourse(String userName) {
        List<StudentEnrolled> enrollments=getStudentEnrollmentByUsername(userName);
        System.out.println("All Enrolled Course:");
        for (StudentEnrolled e : enrollments) {
            System.out.println(e.getCourseName());
        }
    }
    public static List<String> getNonEnrolledCourse(String userName)
    {
        courses = getCourses();

        List<String> result=new ArrayList<>();
        courses.forEach(e->{
            if(!checkCourse(userName,e))
            {
               result.add(e);
            }
        });
      return result;
    }
    public static boolean checkCourse(String userName, String courseName)
    {
        List<StudentEnrolled> enrollments=getStudentEnrollmentByUsername(userName);
        for (StudentEnrolled e:enrollments)
        {
            if(e.getCourseName().equals(courseName))
                return true;
        }
        return false;
    }
    public static void printAllCourses() {
        courses = getCourses();
        System.out.println("All Courses:");
        for (String course : courses) {
            System.out.println(course);
        }
    }

    public static void saveTeacherEnrollment(String username, String courseName) {
        String csvFile = "teacherEnroll.csv";

        try {
            // Check if the file exists
            File file = new File(csvFile);
            boolean fileExists = file.exists();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
                // If file doesn't exist, write the header row
                if (!fileExists) {
                    bw.write("Username,CourseName");
                    bw.newLine();
                }

                // Append the teacher enrollment data to the CSV file
                bw.write(username + "," + courseName);
                bw.newLine();
                System.out.println("Teacher enrollment saved successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteCourse(String username, String courseName) {
        String csvFile = "teacherEnroll.csv";

        // Create a list to store teacher enrollments
        List<TeacherEnrolled> enrollments = new ArrayList<>();

        // Read data from the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    enrollments.add(new TeacherEnrolled(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Remove the enrollment with matching username and course name
        TeacherEnrolled enrollmentToRemove = new TeacherEnrolled(username, courseName);
        if (enrollments.remove(enrollmentToRemove)) {
            System.out.println("Enrollment deleted successfully.");
        } else {
            System.out.println("Enrollment not found.");
            return;
        }

        // Write the updated enrollments back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (TeacherEnrolled enrollment : enrollments) {
                bw.write(enrollment.getUsername() + "," + enrollment.getCourseName());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public static List<TeacherEnrolled> getAllEnrollments(String username) {
        String csvFile = "teacherenroll.csv";
        List<TeacherEnrolled> enrollments = new ArrayList<>();

        // Read data from the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    enrollments.add(new TeacherEnrolled(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // Filter the enrollments based on username and courseName
        List<TeacherEnrolled> filteredEnrollments = new ArrayList<>();
        for (TeacherEnrolled enrollment : enrollments) {
            if (enrollment.getUsername().equals(username) ) {
                filteredEnrollments.add(enrollment);
            }
        }

        return filteredEnrollments;
    }

    public static void printSingleUserEnrolledData(String userNme)
    {
        List<TeacherEnrolled> enrolledData = getAllEnrollments(userNme);
        System.out.println(userNme+" enrolled Courses:");
        System.out.println("CourseName");
        for (TeacherEnrolled enrollment : enrolledData) {
            System.out.println(  enrollment.getCourseName());
        }
    }
    public static void studentEnrollment(String username, String courseName) {
        String csvFile = "StudentEnrolled.csv";

        // Create a new StudentEnrolled object
        StudentEnrolled enrollment = new StudentEnrolled(username, courseName);

        // Check if the file exists
        File file = new File(csvFile);
        boolean fileExists = file.exists();

        // Write the student enrollment data to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            // If file doesn't exist, write the header row
            if (!fileExists) {
                bw.write("Username,CourseName");
                bw.newLine();
            }

            bw.write(enrollment.getUsername() + "," + enrollment.getCourseName());
            bw.newLine();
            System.out.println("Student enrolled successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteStudentEnrollment(String username, String courseName) {
        String csvFile = "StudentEnrolled.csv";


        // Create a list to store student enrollments
        List<StudentEnrolled> enrollments = new ArrayList<>();

        // Read data from the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    enrollments.add(new StudentEnrolled(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Remove the enrollment with matching username and course name
        StudentEnrolled enrollmentToRemove = new StudentEnrolled(username, courseName);
        if (enrollments.remove(enrollmentToRemove)) {
            System.out.println("Student Enrollment deleted successfully.");
        } else {
            System.out.println("Enrollment not found.");
            return;
        }

        // Write the updated enrollments back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (StudentEnrolled enrollment : enrollments) {
                bw.write(enrollment.getUsername() + "," + enrollment.getCourseName());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


    }

public static void printAllStudentsByCourse(String courseName)
{
    List<StudentEnrolled> enrollments = getEnrollmentByCourse(courseName);
    for (StudentEnrolled enrollment : enrollments) {
        System.out.println("Username: " + enrollment.getUsername() + ", CourseName: " + enrollment.getCourseName());
    }
}
    public static List<StudentEnrolled> getEnrollmentByCourse(String courseName) {
        String csvFile = "StudentEnrolled.csv";
        List<StudentEnrolled> enrollments = new ArrayList<>();

        // Read data from the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[1].equals(courseName)) {
                    enrollments.add(new StudentEnrolled(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return enrollments;
    }
    public static List<StudentEnrolled> getStudentEnrollmentByUsername(String username) {
        String csvFile = "StudentEnrolled.csv";
        List<StudentEnrolled> enrollments = new ArrayList<>();

        // Read data from the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    enrollments.add(new StudentEnrolled(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return enrollments;
    }
    public static void saveGrade(String username, String courseName, String grade) {
        String csvFile = "Grades.csv";

        // Create a new Grade object
        Grade newGrade = new Grade(username, courseName, grade);

        // Check if the file exists
        File file = new File(csvFile);
        boolean fileExists = file.exists();

        // Write the grade data to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            // If file doesn't exist, write the header row
            if (!fileExists) {
                bw.write("Username,CourseName,Grade");
                bw.newLine();
            }

            bw.write(newGrade.getUsername() + "," + newGrade.getCourseName() + "," + newGrade.getGrade());
            bw.newLine();
            System.out.println("Grade saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static void printStudentGrade(String userName)
{
    List<Grade> studentGrades=getGradeByUsername(userName);
    System.out.println("CourseName    Grade");
    for (Grade grade : studentGrades) {
        System.out.println(grade.getCourseName()+"  "+grade.getGrade());
    }
}
    public static List<Grade> getGradeByUsername(String username) {
        String csvFile = "Grades.csv";
        List<Grade> grades = new ArrayList<>();

        // Read data from the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals(username)) {
                    grades.add(new Grade(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return grades;
    }
    public static List<TeacherEnrolled> getAllTeacherEnrollmentsCourse() {
        String csvFile = "teacherenroll.csv";
        List<TeacherEnrolled> enrollments = new ArrayList<>();

        // Read data from the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    enrollments.add(new TeacherEnrolled(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // Filter the enrollments based on username and courseName
        List<TeacherEnrolled> filteredEnrollments = new ArrayList<>();
          filteredEnrollments.addAll(enrollments);

        return filteredEnrollments;
    }
    public static boolean checkCourseExistence(String courseName)
    {
        List<TeacherEnrolled> enrollments=getAllTeacherEnrollmentsCourse();
        for(TeacherEnrolled e:enrollments)
        {
            if(e.getCourseName().equals(courseName))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean checkUser(String username) {
        String csvFile = "password.csv";
        List<Password> passwords = new ArrayList<>();

        // Read data from the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    passwords.add(new Password(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Check if the username exists in the list
        for (Password password : passwords) {
            if (password.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
