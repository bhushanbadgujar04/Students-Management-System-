package StudentManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("\n🎓 Student Management System 🎓");
            System.out.println("1️⃣ Add Student");
            System.out.println("2️⃣ Remove Student");
            System.out.println("3️⃣ Update Student");
            System.out.println("4️⃣ Search Student");
            System.out.println("5️⃣ Display All Students");
            System.out.println("6️⃣ Exit");
            System.out.print("Enter Your Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    studentManager.addStudent(new Student(id, name, age, grade));
                    break;

                case 2:
                    System.out.print("Enter Student ID to Remove: ");
                    int removeId = scanner.nextInt();
                    studentManager.removeStudent(removeId);
                    break;

                case 3:
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.nextLine();
                    studentManager.updateStudent(updateId, newName, newAge, newGrade);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = scanner.nextInt();
                    Student student = studentManager.searchStudent(searchId);
                    if (student != null) {
                        System.out.println("✅ Student Found: " + student);
                    } else {
                        System.out.println("❌ Student Not Found!");
                    }
                    break;

                case 5:
                    studentManager.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye! 👋");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid Choice! Please Try Again.");
            }
        }
    }
}

