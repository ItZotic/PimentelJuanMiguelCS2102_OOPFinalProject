import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private final List<Student> students = new ArrayList<>();
   
    public void manageUsers(Scanner scanner) {
        while (true) {
            System.out.println("\n=== User Management ===");
            System.out.println("1. Register Student");
            System.out.println("2. View All Users");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> registerStudent(scanner);
                case 2 -> viewAllUsers();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            
        }
    }

    private void registerStudent(Scanner scanner) {
        System.out.println("Enter full name: ");
        System.out.println("*Surname, First Name, Middle Initial*");
        String name = scanner.nextLine();

        System.out.println("Enter student ID number: ");
        System.out.println("Example: 21-01234");
        String studentId = scanner.nextLine();

        System.out.println("Enter college major: ");
        System.out.println("Example: Computer Science");
        String major = scanner.nextLine();

        System.out.println("Enter affiliation (school enrolled): ");
        System.out.println("Example: BSU");
        String affiliation = scanner.nextLine();

        students.add(new Student(name, studentId, major, affiliation));
        System.out.println("Student registered successfully.");
    }

    private void viewAllUsers() {
        System.out.println("\n=== Registered Students ===");
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            for (Student student : students) {
                System.out.printf("Name: %s | Student ID: %s | Major: %s | Affiliation: %s\n",
                        student.getName(), student.getStudentId(), student.getMajor(), student.getAffiliation());
            }
        }
    }
    private static class Student {
        private final String name;
        private final String studentId;
        private final String major;
        private final String affiliation;

        public Student(String name, String studentId, String major, String affiliation) {
            this.name = name;
            this.studentId = studentId;
            this.major = major;
            this.affiliation = affiliation;
        }

        public String getName() { return name; }
        public String getStudentId() { return studentId; }
        public String getMajor() { return major; }
        public String getAffiliation() { return affiliation; }
    }
}