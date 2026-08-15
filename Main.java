package com.student;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[]args) {
Scanner sc=new Scanner(System.in);
StudentService service=new StudentService();
        while (true) {

            System.out.println("\n================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
try{
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc, service);
                    break;

                case 2:
                    service.displayStudents();
                    break;

                case 3:
                    try {
                        System.out.println("Enter student ID to search:");
                        int searchId = sc.nextInt();
                        if(searchId<=0){
                            System.out.println("Invalid ID! ID must be greater than 0.");
                            break;
                        }
                        service.searchStudent(searchId);
                    }catch(InputMismatchException e){
                        System.out.println("Invalid input! Student ID must be a number.");
                        sc.close();
                }
                    break;

                case 4:
                    try {
                        System.out.println("Enter student ID to update:");
                        int updateId = sc.nextInt();
                        if(updateId<=0){
                            System.out.println("Invalid ID! ID must be greater than 0.");
                            break;
                        }
                        System.out.println("Enter new name:");
                        String newName = sc.next();
                        System.out.println("Enter new age:");
                        int newAge = sc.nextInt();
                        if(newAge < 1 || newAge > 100){
                          System.out.println("Invalid age! Age must be between 1 and 100");
                          break;
                        }
                        System.out.println("Enter new course:");
                        String newCourse = sc.next();
                        service.updateStudent(updateId, newName, newAge, newCourse);
                    }catch(InputMismatchException e){
                        System.out.println("invalid input! please enter the correct data,");
                        sc.close();
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Delete Student ID to delete:");
                        int deleteId = sc.nextInt();
                        if(deleteId<=0){
                            System.out.println("Invalid ID! ID must be a greater than 0.");
                            break;
                        }
                        service.deleteStudent(deleteId);
                    }catch(InputMismatchException e){
                        System.out.println("Invalid input! Student ID must be a number.");
                        sc.close();
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
            }catch(InputMismatchException e){
    System.out.println("Invalid input! please enter a number.");
    sc.nextLine();
            }
        }


    }
    private static void addStudent(Scanner sc, StudentService service) {
try{
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        if(!ValidationUtil.isValidId(id)){
            System.out.println("Invalid ID! Id must be a greather than 0.");
            return;
        }
        if(service.isIdExists(id)){
            System.out.println("Student ID already exists.");
            return;
        }
        System.out.print("Enter student name: ");
        sc.nextLine();
        String name = sc.nextLine();
        if(!ValidationUtil.isValidName(name)){
            System.out.println("Invalid name! Name must contain only letters.");
            return;
        }
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        if(!ValidationUtil.isValidAge(age)){
            System.out.println("Invalid age! Age must be between 1 to 100");
            return;
        }

        System.out.print("Enter student course: ");
        String course = sc.next();
    if(!ValidationUtil.isValidCourse(course)){
        System.out.println("Invalid course! Course must contain only letters.");
        return;
    }

        Student student = new Student(id, name, age, course);

        service.addStudent(student);

        System.out.println("Student added successfully!");
    }catch(InputMismatchException e){
    System.out.println("Invalid input! please enter the correct data.");
    sc.nextLine();
    }
    }
}
