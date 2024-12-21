import java.util.ArrayList;
import java.util.Scanner;
class Student {
private String name;
private int rollNumber;
private String course;
private double grade;
// Constructor to initialize student details
public Student(String name, int rollNumber, String course, double grade) {
this.name = name;
this.rollNumber = rollNumber;
this.course = course;
this.grade = grade;
}
// Getters for student details
public String getName() {
return name;
}
public int getRollNumber() {
return rollNumber;
}
public String getCourse() {
return course;
}
public double getGrade() {
return grade;
}
// toString method to display student details
@Override
public String toString() {
    return "Roll No: " + rollNumber + ", Name: " + name + ", Course: " + course + ", Grade: " +
grade;
}
}
public class StudentManagementSystem {
private final ArrayList<Student> students = new ArrayList<>();
private final Scanner scanner = new Scanner(System.in);
// Main method to start the program
public static void main(String[] args) {
StudentManagementSystem system = new StudentManagementSystem();
system.start();
}
// Method to start the system and display the menu
public void start() {
System.out.println("Welcome to the Student Management System!");
int choice;
do {
displayMenu();
choice = scanner.nextInt();
scanner.nextLine(); // Clear buffer
switch (choice) {
case 1 -> addStudent();
case 2 -> viewStudents();
case 3 -> updateStudent();
case 4 -> deleteStudent();
case 5 -> System.out.println("Thank you for using the Student Management System.Goodbye!");
default -> System.out.println("Invalid choice. Please try again.");
}
} while (choice != 5);
}
// Method to display the menu options
private void displayMenu() {
System.out.println("\nStudent Menu:");
System.out.println("1. Add Student");
System.out.println("2. View All Students");
System.out.println("3. Update Student");
System.out.println("4. Delete Student");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");
}
// Method to add a new student
private void addStudent() {
System.out.print("Enter student name: ");
String name = scanner.nextLine();
System.out.print("Enter student roll number: ");
int rollNumber = scanner.nextInt();
scanner.nextLine(); // Clear buffer
System.out.print("Enter student course: ");
String course = scanner.nextLine();
System.out.print("Enter student grade: ");
double grade = scanner.nextDouble();
students.add(new Student(name, rollNumber, course, grade));
System.out.println("Student added successfully!");
}
// Method to view all students
private void viewStudents() {
if (students.isEmpty()) {
System.out.println("No students in the system.");
} else {
System.out.println("\nList of Students:");
for (Student student : students) {
System.out.println(student);
}
}
}
// Method to update student details
private void updateStudent() {
System.out.print("Enter the roll number of the student to update: ");
int rollNumber = scanner.nextInt();
scanner.nextLine(); // Clear buffer
for (Student student : students) {
    if (student.getRollNumber() == rollNumber) {
    System.out.print("Enter new course: ");
    String newCourse = scanner.nextLine();
    System.out.print("Enter new grade: ");
    double newGrade = scanner.nextDouble();
    students.set(students.indexOf(student), new Student(student.getName(),
    student.getRollNumber(), newCourse, newGrade));
    System.out.println("Student details updated successfully!");
    return;
    }
    }
    System.out.println("Student with the given roll number not found.");
    }
    // Method to delete a student from the system
    private void deleteStudent() {
    System.out.print("Enter the roll number of the student to delete: ");
    int rollNumber = scanner.nextInt();
    scanner.nextLine(); // Clear buffer
    for (Student student : students) {
    if (student.getRollNumber() == rollNumber) {
    students.remove(student);
    System.out.println("Student deleted successfully!");
    return;
    }
    }
    System.out.println("Student with the given roll number not found.");
    }
    }