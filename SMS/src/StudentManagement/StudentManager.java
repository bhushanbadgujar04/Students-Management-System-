package StudentManagement;

import java.io.*;
import java.util.*;

public class StudentManager {
    private HashMap<Integer, Student> studentRecords;
    private static final String FILE_NAME = "students.dat";

    public StudentManager() {
        this.studentRecords = new HashMap<>();
        loadFromFile();
    }

    // Add Student
    public void addStudent(Student student) {
        studentRecords.put(student.getId(), student);
        saveToFile();
        System.out.println("✅ Student Added Successfully!");
    }

    // Remove Student
    public void removeStudent(int id) {
        if (studentRecords.containsKey(id)) {
            studentRecords.remove(id);
            saveToFile();
            System.out.println("✅ Student Removed Successfully!");
        } else {
            System.out.println("❌ Student Not Found!");
        }
    }

    // Update Student
    public void updateStudent(int id, String name, int age, String grade) {
        if (studentRecords.containsKey(id)) {
            Student student = studentRecords.get(id);
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            saveToFile();
            System.out.println("✅ Student Updated Successfully!");
        } else {
            System.out.println("❌ Student Not Found!");
        }
    }

    // Search Student by ID
    public Student searchStudent(int id) {
        return studentRecords.getOrDefault(id, null);
    }

    // Display All Students
    public void displayAllStudents() {
        if (studentRecords.isEmpty()) {
            System.out.println("No Students Found!");
        } else {
            for (Student student : studentRecords.values()) {
                System.out.println(student);
            }
        }
    }

    // Save to File (Serialization)
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentRecords);
        } catch (IOException e) {
            System.out.println("❌ Error Saving Data: " + e.getMessage());
        }
    }

    // Load from File (Deserialization)
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentRecords = (HashMap<Integer, Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No Existing Data Found. Starting Fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Error Loading Data: " + e.getMessage());
        }
    }
}

