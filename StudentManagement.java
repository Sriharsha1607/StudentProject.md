import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    String department;
    int marks;
    Student(int id, String name, String department, int marks){
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }
}

public class StudentManagement{

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Student data
    static void addStudent(){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        students.add(new Student(id, name, dept, marks));
        System.out.println("Student added successfully!");
    }

    // View Students data
    static void viewStudents(){
        if(students.isEmpty()){
            System.out.println("No student records found.");
            return;
        }

        for(Student s : students){
            System.out.println(
                "ID: " + s.id +
                ", Name: " + s.name +
                ", Dept: " + s.department +
                ", Marks: " + s.marks
            );
        }
    }

    // Update Student data
    static void updateStudent(){
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        for(Student s : students){
            if(s.id == id){
                sc.nextLine();
                System.out.print("Enter new Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter new Department: ");
                s.department = sc.nextLine();

                System.out.print("Enter new Marks: ");
                s.marks = sc.nextInt();

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete Student data
    static void deleteStudent(){
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for(Student s : students){
            if(s.id == id){
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
