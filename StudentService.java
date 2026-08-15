package com.student;
import java.util.ArrayList;
public class StudentService {
    private ArrayList<Student> students=StudentFileManager.loadStudents();
    public void addStudentFromFile(Student student){
        students.add(student);
    }
    public void addStudent(Student student){
        students.add(student);
        StudentFileManager.saveStudents(students);
    }
    public void displayStudents(){
    for (Student student : students) {

        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Course: " + student.getCourse());

        System.out.println("----------------");

    }
    }
    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("Student found!");
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Course: " + student.getCourse());

                return;
            }
        }

        System.out.println("Student not found!");
    }
    public void updateStudent(int id, String name, int age, String course) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
StudentFileManager.saveStudents(students);
                System.out.println("Student updated successfully!");

                return;
            }
        }

        System.out.println("Student not found!");
    }
    public void deleteStudent(int id) {

        for (int i=0;i<students.size();i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);
StudentFileManager.saveStudents(students);
                System.out.println("Student deleted successfully!");

                return;
            }
        }

        System.out.println("Student not found!");
    }
    public  boolean isIdExists(int id){
        for(Student student:students){
            if(student.getId()==id){
                return true;
            }
        }
        return false;
    }
}
