package com.student;

public class ValidationUtil {
    public static boolean isValidId(int id){
        return id>0;
    }
    public static boolean isValidAge(int age){
        return age>=1 && age<=100;
    }
    public static boolean isValidName(String name){
        return name.matches("[a-zA-Z ]+");
    }
    public static boolean isValidCourse(String course){
        return course.matches("[a-zA-z ]+");
    }
}
